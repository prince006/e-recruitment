package dao;

import java.util.ArrayList;
import java.util.List;

import hibernate.HibernateSessionFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pojo.Exam;
import pojo.Job;
import pojo.Resume;
import pojo.Resume_Experience;
import pojo.Resume_qualification;
import pojo.UserPojo;

public class ResumeDao {

	public boolean insert(Resume pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(pojo);
		session.getTransaction().commit();
		return true;
	}

	public boolean insert(Resume_Experience pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(pojo);
		session.getTransaction().commit();
		return true;
	}

	public boolean insert(Resume_qualification pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(pojo);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Resume pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.saveOrUpdate(pojo);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Resume_Experience pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.saveOrUpdate(pojo);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Resume_qualification pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.saveOrUpdate(pojo);
		session.getTransaction().commit();
		return true;
	}

	public boolean resumeCreation(UserPojo userPojo) {

		Session session = null;
		boolean flag = false;
		try {
			Criteria criteria = HibernateSessionFactory.getSession()
					.createCriteria(Resume.class);
			criteria.add(Restrictions.eq("created_by", userPojo.getUSER_ID()
					.toString()));
			if (!criteria.list().isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return flag;
	}

	public Resume searchByUser(UserPojo userPojo) {
	
		Criteria criteria = HibernateSessionFactory.getSession()
				.createCriteria(Resume.class);
		criteria.add(Restrictions.eq("created_by", userPojo.getUSER_ID()
				.toString()));
		Resume resume = (Resume) criteria.list().get(0);
		HibernateSessionFactory.getSession().close();
		return resume;
	}
	
	@SuppressWarnings("unchecked")
	public List<Resume_qualification> getQualification(Resume resume) {		
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Resume_qualification.class);
		criteria.add(Restrictions.eq("resume", resume));
		HibernateSessionFactory.getSession().flush();
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	public List<Resume_Experience> getExperience(Resume resume) {		
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Resume_Experience.class);
		criteria.add(Restrictions.eq("resume", resume));
		HibernateSessionFactory.getSession().flush();
		return criteria.list();
	}
	public Resume search(Integer ID) {
		Resume r =(Resume) HibernateSessionFactory.getSession().get(Resume.class,ID);
		HibernateSessionFactory.getSession().flush();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<Resume> list()
	{
		return HibernateSessionFactory.getSession().createCriteria(Resume.class).addOrder(Order.asc("Resume_no")).list();
	}
	
	public List<Resume> search(Resume pojo) {
		Criteria criteria = HibernateSessionFactory.getSession()
				.createCriteria(Resume.class);

		if (pojo.getTitle() != null)
			criteria.add(Restrictions.ilike("title", "%" + pojo.getTitle()
					+ "%"));
		if (pojo.getFirst_name() != null)
			criteria.add(Restrictions.ilike("first_name",
					"%" + pojo.getFirst_name() + "%"));
		if (pojo.getLast_name() != null)
			criteria.add(Restrictions.ilike("last_name", "%" + pojo.getLast_name()
					+ "%"));
		if (pojo.getGender() != null && !pojo.getGender().equals("0"))
			criteria.add(Restrictions.ilike("gender", "%" + pojo.getGender()
					+ "%"));

		if (pojo.getIs_married() != null && !pojo.getIs_married().equals("0"))
			criteria.add(Restrictions.ilike("is_married",
					"%" + pojo.getIs_married() + "%"));
	
		if (pojo.getRating() != null)
			criteria.add(Restrictions.eq("rating", pojo.getRating()));
		
		if (pojo.getExp() != null)
			criteria.add(Restrictions.eq("exp", pojo.getExp()));
		
		criteria.add(Restrictions.eq("is_active","Y"));		
		criteria.addOrder(Order.asc("resume_no"));
		return criteria.list();
	}


	public List<Resume> listAll(Integer ID) {
		List<Resume> result = new ArrayList<Resume>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from resume_info where resume_no not in (select resume_no from purchased_resume_info where user_id="+ ID + " union select resume_no from saved_resume_info where user_id="+ ID + ")";
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
	
	public List<Resume> listSaved(Integer ID) {
		List<Resume> result = new ArrayList<Resume>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from resume_info where resume_no in (select resume_no from saved_resume_info where user_id="+ ID + " and resume_no not in (select resume_no from purchased_resume_info where user_id="+ ID + "))";
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
	
	public List<Resume> listPurchased(Integer ID) {
		List<Resume> result = new ArrayList<Resume>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from resume_info where resume_no in (select resume_no from purchased_resume_info where user_id="+ ID + " )";
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
	public static void main(String[] args) {
		Resume ra= new Resume();
//		ra.setTitle("Java");
		ra.setRating(2.0);
	
		List<Resume> r =new ResumeDao().search(ra);
		for (Resume resume : r) {
			System.out.println(resume.getFirst_name());
		}
		
	}
}
