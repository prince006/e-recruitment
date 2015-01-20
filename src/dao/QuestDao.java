package dao;


import java.util.ArrayList;
import java.util.List;

import hibernate.HibernateSessionFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pojo.Advert;
import pojo.Job;
import pojo.Question;
import pojo.UserPojo;

public class QuestDao {

	public boolean insert(Question pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(pojo);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Question pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.update(pojo);
		session.getTransaction().commit();
		if (session != null) {
			session.close();
		}
		return true;
	}

	public List<Question> list() {
		return HibernateSessionFactory.getSession()
				.createCriteria(Question.class).addOrder(Order.asc("qus_no"))
				.list();
	}
	
	public List<Question> listAdminQuestion() {
		List<Question> result = new ArrayList<Question>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.flush();
			String sql = "select * from qus_info where created_by in (select user_id from userpojo where category='A') and is_active <> 'X'";
			Query query = session.createSQLQuery(sql).addEntity(Question.class);
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

	public Question search(Integer ID) {
		return (Question) HibernateSessionFactory.getSession().get(Question.class,
				ID);
	}

	@SuppressWarnings("unchecked")
	public List<Question> search(Question pojo,UserPojo upojo) 
	{
		Criteria criteria = HibernateSessionFactory.getSession()
				.createCriteria(Question.class);

		if (pojo.getQus() != null)
			criteria.add(Restrictions.ilike("qus", "%" + pojo.getQus()
					+ "%"));
		if (pojo.getAnsa() != null)
			criteria.add(Restrictions.ilike("ansa", "%" + pojo.getAnsa()
					+ "%"));
		if (pojo.getAnsb() != null)
			criteria.add(Restrictions.ilike("ansb", "%" + pojo.getAnsb()
					+ "%"));
		if (pojo.getAnsc() != null)
			criteria.add(Restrictions.ilike("ansc", "%" + pojo.getAnsc()
					+ "%"));
		if (pojo.getAnsd() != null)
			criteria.add(Restrictions.ilike("ansd", "%" + pojo.getAnsd()
					+ "%"));
		criteria.add(Restrictions.ne("is_active","X"));
		criteria.add(Restrictions.eq("created_by",upojo.getUSER_ID().toString()));
		criteria.addOrder(Order.asc("qus_no"));
		return criteria.list();
	}

	public static void main(String a[]) {
		// List<Advert> adverts=new AdvertDao().list();
		// for (Advert advert : adverts) {
		// System.out.println(advert.getSubject());
		// }
		// Advert advert= new AdvertDao().search(1);
		// System.out.println(advert.getSubject());
//		Advert advert1 = new Advert();
//		advert1.setDescription("a");
//		advert1.setSubject("a");
//		new QuestDao().insert(advert1);
//		List<Advert> adverts = new AdvertDao().search(advert1);
//		for (Advert advert : adverts) {
//			System.out.println(advert.getSubject());
//		}

	}
}
