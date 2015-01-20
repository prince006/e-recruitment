package dao;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import hibernate.HibernateSessionFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pojo.Advert;
import pojo.Exam;
import pojo.Question;
import pojo.Resume;

public class AdvertDao {

	public boolean insert(Advert pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(pojo);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Advert pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.update(pojo);
		session.getTransaction().commit();
		return true;
	}

	public List<Advert> list() {
		List<Advert> result = new ArrayList<Advert>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = " select * from adv_info where is_active<>'X'";
			Query query = session.createSQLQuery(sql).addEntity(Advert.class);
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

	public Advert search(Integer ID) {
		return (Advert) HibernateSessionFactory.getSession().get(Advert.class,
				ID);
	}

	@SuppressWarnings("unchecked")
	public List<Advert> search(Advert pojo) {
		Criteria criteria = HibernateSessionFactory.getSession()
				.createCriteria(Advert.class);

		if (pojo.getSubject() != null)
			criteria.add(Restrictions.ilike("subject", "%" + pojo.getSubject()
					+ "%"));

		if (pojo.getDescription() != null)
			criteria.add(Restrictions.ilike("description",
					"%" + pojo.getDescription() + "%"));

		criteria.addOrder(Order.asc("adv_no"));
		return criteria.list();
	}
	public Advert generateRandomAdvert() {
		Random randomGenerator = new Random();
		int randomInt;
		List<Advert> alist = new AdvertDao().list();							
		randomInt = randomGenerator.nextInt(alist.size());
		if(randomInt==0)
			randomInt++;
		System.out.println(randomInt);
		return search(randomInt);		
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
//		new AdvertDao().insert(advert1);
//		List<Advert> adverts = new AdvertDao().search(advert1);
//		for (Advert advert : adverts) {
//			System.out.println(advert.getSubject());
//		}
Advert add = new AdvertDao().generateRandomAdvert();
System.out.println(add.getUrl());
	}
}
