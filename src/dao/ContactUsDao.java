package dao;
import java.util.List;

import hibernate.HibernateSessionFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import pojo.ContactUsPojo;
import pojo.Job;
public class ContactUsDao
{
	public boolean contactUsSubmit(ContactUsPojo contact)
	{
		try{
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.saveOrUpdate(contact);
			session.getTransaction().commit();
			return true;	
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<ContactUsPojo> getContactLists()
	{
		Criteria criteria=HibernateSessionFactory.getSession().createCriteria(ContactUsPojo.class);
		criteria.addOrder(Order.asc("Contact_ID"));
		return criteria.list();
	}
	
	
	
}
