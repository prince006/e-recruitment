package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hibernate.HibernateSessionFactory;

import org.dom4j.util.UserDataAttribute;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.sun.org.apache.xpath.internal.operations.Bool;

import pojo.Advert;
import pojo.Job;
import pojo.Resume;
import pojo.Resume_Experience;
import pojo.UserPojo;

public class JobDao {

	public boolean insert(Job pojo) {
		try {
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.saveOrUpdate(pojo);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean update(Job pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.update(pojo);
		session.getTransaction().commit();
		return true;
	}

	public List<Job> list(UserPojo pojo) {
		Criteria criteria = HibernateSessionFactory.getSession()
				.createCriteria(Job.class);

		criteria.add(Restrictions.eq("created_by",pojo.getUSER_ID().toString()));
		criteria.addOrder(Order.asc("job_no"));
		return criteria.list();
	}
	
	public List<Job> listJobs()
	{
		Criteria criteria=HibernateSessionFactory.getSession().createCriteria(Job.class);
		criteria.addOrder(Order.asc("job_no"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Job> listUnapplied(Integer ID) {
		List<Job> result = new ArrayList<Job>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from job_info where job_no not in (select job_no from user_job_info where user_id="
					+ ID + ") and expire_date >= date(now())";
			Query query = session.createSQLQuery(sql).addEntity(Job.class);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public List<Job> prefferedJob(UserPojo uPojo) {	
		Resume r = new ResumeDao().searchByUser(uPojo);		
		Job pojo= new Job();
		pojo.setSkill_req(r.getSkills());
		pojo.setLocation(r.getC_address());
		return searchPerf(pojo);
	}
	
	public List<Job> searchPerf(Job pojo) {
		Criteria criteria = HibernateSessionFactory.getSession()
				.createCriteria(Job.class);

		Criterion crit1 = Restrictions.ilike("skill_req", "%" + pojo.getSkill_req()	+ "%");		
		Criterion crit2 = Restrictions.ilike("location", "%" + pojo.getLocation() + "%");						
		criteria.add(Restrictions.or(crit1, crit2));
		criteria.addOrder(Order.asc("job_no"));
		return criteria.list();
	}
	
	public List<Resume> viewApplicants(Integer ID) {
		List<Resume> result = new ArrayList<Resume>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from resume_info where created_by in (select user_id from user_job_info where job_no="
					+ ID + ")";
			Query query = session.createSQLQuery(sql).addEntity(Resume.class);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public List<Resume> viewPAssedResume(Integer Exam_ID) {
		List<Resume> result = new ArrayList<Resume>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from resume_info where created_by in (select user_id from exam_takers_info where exam_no="
					+ Exam_ID + ")";
			Query query = session.createSQLQuery(sql).addEntity(Resume.class);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public List<Job> viewSavedJob(Integer ID) {
		List<Job> result = new ArrayList<Job>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from job_info where job_no in (select job_no from user_saved_job where user_id="
					+ ID
					+ " and job_no not in (select job_no from user_job_info where user_id="
					+ ID + ")  and expire_date >= date(now()))";
			Query query = session.createSQLQuery(sql).addEntity(Job.class);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public List<Job> viewAppliedJob(Integer ID) {
		List<Job> result = new ArrayList<Job>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from job_info where job_no in (select job_no from user_job_info where user_id="
					+ ID + ")";
			Query query = session.createSQLQuery(sql).addEntity(Job.class);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public Job search(Integer ID) {
		return (Job) HibernateSessionFactory.getSession().get(Job.class, ID);
	}
	
	public String isJobSaved(Integer UID,Integer JID) {
		
		Session session = null;
		String flag="0";
		try {
			session = HibernateSessionFactory.getSession();
			String sql = " select * from user_saved_job where job_no ="+JID+" and user_id="+UID+"";
			Query query = session.createSQLQuery(sql);
			List<Object[]> lst = query.list();
			if (lst.size()!=0)
				flag="1";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return flag;
	}
	
	public String isJobApplied(Integer UID,Integer JID) {
		
		Session session = null;
		String flag="0";
		try {
			session = HibernateSessionFactory.getSession();
			String sql = " select * from user_job_info where job_no ="+JID+" and user_id="+UID+"";
			Query query = session.createSQLQuery(sql);
			List<Object[]> lst = query.list();
			if (lst.size()!=0)
				flag="1";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return flag;
	}
     

	@SuppressWarnings("unchecked")
	public List<Job> search(Job pojo) {
		Criteria criteria = HibernateSessionFactory.getSession()
				.createCriteria(Job.class);

		if (pojo.getTitle() != null)
			criteria.add(Restrictions.ilike("title", "%" + pojo.getTitle() + "%"));

		if (pojo.getDescription() != null)
			criteria.add(Restrictions.ilike("description", "%" + pojo.getDescription() + "%"));		
		
		if (pojo.getSkill_req() != null)
			criteria.add(Restrictions.ilike("skill_req", "%" + pojo.getSkill_req()	+ "%"));

		if (pojo.getJob_cat() != null)
			criteria.add(Restrictions.ilike("job_cat", "%" + pojo.getJob_cat()	+ "%"));
		
		if (pojo.getJob_role() != null)
			criteria.add(Restrictions.ilike("job_role", "%" + pojo.getJob_role() + "%"));
		
		if (pojo.getEmp_type() != null)
			criteria.add(Restrictions.ilike("emp_type", "%" + pojo.getEmp_type() + "%"));
		
		if (pojo.getFun_area() != null)
			criteria.add(Restrictions.ilike("fun_area", "%" + pojo.getFun_area() + "%"));
		
		if (pojo.getLocation() != null)
			criteria.add(Restrictions.ilike("location", "%" + pojo.getLocation() + "%"));
		
		if (pojo.getExpire_date() != null)
			criteria.add(Restrictions.ilike("expire_date", "%" + pojo.getExpire_date() + "%"));
						
		if (pojo.getMin_exp() != null)
			criteria.add(Restrictions.ilike("min_exp", "%" + pojo.getMin_exp() + "%"));
		
		if (pojo.getMax_exp() != null)
			criteria.add(Restrictions.ilike("max_exp", "%" + pojo.getMax_exp() + "%"));
		
			criteria.add(Restrictions.eq("is_active", "Y"));
		
		criteria.addOrder(Order.asc("job_no"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Job> search(Job pojo, UserPojo upojo) {
		Criteria criteria = HibernateSessionFactory.getSession()
				.createCriteria(Job.class);

		if (pojo.getTitle() != null)
			criteria.add(Restrictions.ilike("title", "%" + pojo.getTitle()
					+ "%"));
		if (pojo.getExpire_date() != null)
			criteria.add(Restrictions.ilike("expire_date",
					"%" + pojo.getExpire_date() + "%"));
		if (pojo.getMin_exp() != null)
			criteria.add(Restrictions.ilike("min_exp", "%" + pojo.getMin_exp()
					+ "%"));
		if (pojo.getMax_exp() != null)
			criteria.add(Restrictions.ilike("max_exp", "%" + pojo.getMax_exp()
					+ "%"));

		if (pojo.getDescription() != null)
			criteria.add(Restrictions.ilike("description",
					"%" + pojo.getDescription() + "%"));
		
		if (pojo.getSkill_req() != null)
			criteria.add(Restrictions.ilike("skill_req", "%" + pojo.getSkill_req()	+ "%"));

		if (pojo.getJob_cat() != null)
			criteria.add(Restrictions.ilike("job_cat", "%" + pojo.getJob_cat()	+ "%"));
		
		if (pojo.getJob_role() != null)
			criteria.add(Restrictions.ilike("job_role", "%" + pojo.getJob_role() + "%"));
		
		if (pojo.getEmp_type() != null)
			criteria.add(Restrictions.ilike("emp_type", "%" + pojo.getEmp_type() + "%"));
		
		if (pojo.getFun_area() != null)
			criteria.add(Restrictions.ilike("fun_area", "%" + pojo.getFun_area() + "%"));
		
		if (pojo.getLocation() != null)
			criteria.add(Restrictions.ilike("location", "%" + pojo.getLocation() + "%"));

		
		criteria.add(Restrictions.eq("created_by",upojo.getUSER_ID().toString()));
		criteria.addOrder(Order.asc("job_no"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public static void main(String a[]) {
		// List<Advert> adverts=new AdvertDao().list();
		// for (Advert advert : adverts) {
		// System.out.println(advert.getSubject());
		// }
		// Advert advert= new AdvertDao().search(1);
		// System.out.println(advert.getSubject());
		// Advert advert1 = new Advert();
		// advert1.setDescription("a");
		// advert1.setSubject("a");
		// new JobDao().insert(advert1);
		// List<Advert> adverts = new AdvertDao().search(advert1);
		// for (Advert advert : adverts) {
		// System.out.println(advert.getSubject());
		// }

		// Job job=new Job();
		// job=new JobDao().search(1);
		// Set<UserPojo> pojo = new HashSet<UserPojo>();
		// int i=0;
		// for (UserPojo userPojo : new UserDAO().list()) {
		// if(i!=2)
		// pojo.add(userPojo);
		// i++;
		// }
		// job.setApplicants(pojo);
		// job.setTitle("Unix admin");
		// new JobDao().insert(job);
		// UserPojo u = new UserDAO().search(1);
		// Set<Job> xpojo = new HashSet<Job>();
		// for (Job pojo : new JobDao().list()) {
		// xpojo.add(pojo);
		// }
		// u.setJOBS(xpojo);
		// new UserDAO().insert(u);
        System.out.println(new JobDao().isJobApplied(3,1));
	}
}
