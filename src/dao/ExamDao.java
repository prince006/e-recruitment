package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.text.StyledEditorKit.BoldAction;

import hibernate.HibernateSessionFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pojo.Exam;
import pojo.Question;
import pojo.QuestionExt;
import pojo.Resume;
import pojo.UserPojo;

public class ExamDao {

	public boolean insert(Exam pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.flush();
		session.beginTransaction();
		session.saveOrUpdate(pojo);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean update(Exam pojo) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.update(pojo);
		session.getTransaction().commit();
		return true;
	}

	public boolean validateExam(List<QuestionExt> pojo, Integer examq) {
		int flag = 0;
		for (QuestionExt questionExt : pojo) {
			if(questionExt.getCorrectans()!=null){
				if (questionExt.getCorrectans().equalsIgnoreCase(questionExt.getReponse()))
					flag++;	
			}			
		}
		if (flag >= examq)
			return true;
		else
			return false;
	}

	public List<Exam> list() {
		return HibernateSessionFactory.getSession().createCriteria(Exam.class)
				.addOrder(Order.asc("exam_no")).list();
	}

	public List<Exam> listEmpExams(UserPojo userPojo) {
		List<Exam> result = new ArrayList<Exam>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from exam_info where created_by ='"
					+ userPojo.getUSER_ID() + "-S' AND Is_Active <> 'X'";
			Query query = session.createSQLQuery(sql).addEntity(Exam.class);
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

	public List<Exam> listPuchasedExams(UserPojo userPojo) {
		List<Exam> result = new ArrayList<Exam>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from exam_info where created_by ='"
					+ userPojo.getUSER_ID() + "-P'";
			Query query = session.createSQLQuery(sql).addEntity(Exam.class);
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

	public Exam search(Integer ID) {
		Exam e = (Exam) HibernateSessionFactory.getSession()
				.get(Exam.class, ID);
		HibernateSessionFactory.getSession().flush();
		return e;
	}

	@SuppressWarnings("unchecked")
	public List<Exam> search(Exam pojo) {
		Criteria criteria = HibernateSessionFactory.getSession()
				.createCriteria(Exam.class);

		if (pojo.getMin_pass() != null)
			criteria.add(Restrictions.eq("min_pass", pojo.getMin_pass()
					.intValue()));

		if (pojo.getNo_of_qus() != null)
			criteria.add(Restrictions.eq("no_of_qus", pojo.getNo_of_qus()
					.intValue()));

		if (pojo.getExam_time() != null)
			criteria.add(Restrictions.eq("exam_time", pojo.getExam_time()
					.intValue()));

		criteria.addOrder(Order.asc("exam_no"));
		return criteria.list();
	}

	public Boolean generateRandomExam(Exam pojo) {
		Random randomGenerator = new Random();
		int randomInt;
		List<Integer> generated = new ArrayList<Integer>();
		List<Question> qlist = new QuestDao().listAdminQuestion();
		Set<Question> qset = new HashSet<Question>();
		if (pojo.getNo_of_qus() <= qlist.size()) {
			System.out.println("in if");
			for (int idx = 1; idx <= pojo.getNo_of_qus(); ++idx) {
				while (true) {
					randomInt = randomGenerator.nextInt(qlist.size());
					if (!generated.contains(randomInt)) {
						// Done for this iteration
						generated.add(randomInt);
						break;
					}
				}
				qset.add(qlist.get(randomInt));
			}
			pojo.setQuestions(qset);
			insert(pojo);
			return true;
		} else {
			System.out.println("in else");
			return false;
		}
	}

	public List<Exam> listUnClear(Integer ID) {
		List<Exam> result = new ArrayList<Exam>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from exam_info where exam_no not in (select exam_no from exam_takers_info where user_id=" + ID + " ) and is_active='Y'";
			Query query = session.createSQLQuery(sql).addEntity(Exam.class);
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

	public List<Exam> listCleared(Integer ID) {
		List<Exam> result = new ArrayList<Exam>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String sql = "select * from exam_info where exam_no in (select exam_no from exam_takers_info where user_id="
					+ ID + " )";
			Query query = session.createSQLQuery(sql).addEntity(Exam.class);
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
		// Exam exam= new Exam();
		// exam.setMin_pass(10);
		// List<Exam> el= new ExamDao().search(exam);
		// for (Exam exam2 : el) {
		// System.out.println(exam2.getExam_no());
		// }
		// Exam pojo = new ExamDao().search(1);
		// Set<Question> qs=new HashSet<Question>();
		// Question q= new Question();
		// q.setQus("adas");
		// qs.add(q);
		// pojo.setQuestions(qs);
		// new ExamDao().insert(pojo);

		// Random randomGenerator = new Random();
		// List<Integer> generated = new ArrayList<Integer>();
		// List<Question> qlist= new QuestDao().listAdminQuestion();
		// Set<Question> qset= new HashSet<Question>();
		// int randomInt;
		// for (int idx = 1; idx <= 10; ++idx)
		// {
		// while(true)
		// {
		// randomInt = randomGenerator.nextInt(qlist.size());
		// if (!generated.contains(randomInt))
		// {
		// // Done for this iteration
		// generated.add(randomInt);
		// break;
		// }
		// }
		// qset.add(qlist.get(randomInt));
		// System.out.println(qlist.get(randomInt).getQus_no() + "Added");
		// }
//		UserPojo userPojo = new UserDAO().search(3);
//		Exam exam = new ExamDao().search(1);
//		Set<UserPojo> up = exam.getTakers();
//		up.add(userPojo);
//		exam.setTakers(up);
//		new ExamDao().insert(exam);
		Exam result = new ExamDao().search(1);
		List<QuestionExt> qe = new ArrayList<QuestionExt>();
		for (Question q : result.getQuestions()) {
			qe.add(new QuestionExt(q,"A"));
		}
		System.out.println(new ExamDao().validateExam(qe, 9));
		

	}

}
