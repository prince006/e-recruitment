package dao;

import hibernate.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pojo.Advert;
import pojo.Question;
import pojo.UserPojo;

public class UserDAO 
{
	public UserPojo getUserPojo(String email, String password)
	{
		return (UserPojo)HibernateSessionFactory.getSession().createQuery("from UserPojo where EMAIL = :email and PASSWORD = :password").setString("email", email).setString("password", password).uniqueResult();
	}
	
	public UserPojo getUserPojo(String email)
	{
		return (UserPojo)HibernateSessionFactory.getSession().createQuery("from UserPojo where EMAIL = :email").setString("email", email).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserPojo> list() {
		List<UserPojo> result = new ArrayList<UserPojo>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.flush();
			String sql = " select * from userpojo where is_active<>'X'";
			Query query = session.createSQLQuery(sql).addEntity(UserPojo.class);
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
	
	public UserPojo getUserAuthenticate(String EMAIL)
	{
		return (UserPojo)HibernateSessionFactory.getSession().createQuery("from UserPojo where EMAIL = :email ").setString("email", EMAIL).uniqueResult();
	}
	
	public UserPojo search(Integer USERID)
	{
		UserPojo u=(UserPojo)HibernateSessionFactory.getSession().get(UserPojo.class, USERID);
		HibernateSessionFactory.getSession().flush();
		return u;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserPojo> search(UserPojo userPojo)
	{
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(UserPojo.class);
		
		if(userPojo.getCATEGORY()!=null && !userPojo.getCATEGORY().isEmpty() && !userPojo.getCATEGORY().equals("0"))
			criteria.add(Restrictions.ilike("CATEGORY", userPojo.getCATEGORY()));
		
		if(userPojo.getCITY()!=null)
			criteria.add(Restrictions.ilike("CITY", "%"+userPojo.getCITY()+"%"));
			
		if(userPojo.getEMAIL()!=null)
			criteria.add(Restrictions.ilike("EMAIL", "%"+userPojo.getEMAIL()+"%"));
		
		if(userPojo.getMOBILE()!=null)
			criteria.add(Restrictions.ilike("MOBILE", "%"+userPojo.getMOBILE()+"%"));
		
		if(userPojo.getNAME()!=null)
			criteria.add(Restrictions.ilike("NAME", "%"+userPojo.getNAME()+"%"));
		
		if(userPojo.getSTATE()!=null)
			criteria.add(Restrictions.ilike("STATE", "%"+userPojo.getSTATE()+"%"));
		
		criteria.addOrder(Order.asc("USER_ID"));
		return criteria.list();
	}
	
	public List<UserPojo> search(String email)
	{
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(UserPojo.class);
		criteria.add(Restrictions.eq("EMAIL",email));		
		return criteria.list();
	}
	public boolean insert(UserPojo userPojo)
	{
		try{
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.saveOrUpdate(userPojo);
			session.getTransaction().commit();
			return true;	
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(UserPojo userPojo)
	{
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.update(userPojo);
		session.getTransaction().commit();
		if (session != null) {
			session.close();
		}
		return true;
	}

}
