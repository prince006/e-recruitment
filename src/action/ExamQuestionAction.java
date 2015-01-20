package action;

import hibernate.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Exam;
import pojo.Question;
import pojo.UserPojo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import dao.ExamDao;
import dao.QuestDao;

public class ExamQuestionAction extends ActionSupport implements
		ModelDriven<List<Question>>, Preparable, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Question> questList;
	private String action;
	@SuppressWarnings("rawtypes")
	private Map session;
	private ExamDao examDao;
	private QuestDao questDao;

	public QuestDao getQuestDao() {
		return questDao;
	}

	public void setQuestDao(QuestDao questDao) {
		this.questDao = questDao;
	}

	public ExamDao getExamDao() {
		return examDao;
	}

	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public List<Question> getQuestList() {
		return questList;
	}

	public void setQuestList(List<Question> questList) {
		this.questList = questList;
	}

	public List<Question> getModel() {
		// TODO Auto-generated method stub
		return questList;
	}

	@Override
	public void prepare() {
		questList = new ArrayList<Question>();
		setSession(ActionContext.getContext().getSession());
		Exam e = (Exam) session.get("exam");
		action= (String) session.get("action");		
		if(!action.equals("showp")){
			for (int i = 0; i < e.getNo_of_qus(); i++) {
				questList.add(new Question());
			}	
		}		
	}

	public String qustAdd() throws Exception {
		System.out.println("in method");
		setSession(ActionContext.getContext().getSession());
		Exam pojo = (Exam) session.get("exam");

		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		if (action.equals("show")) {
			if(!pojo.getQuestions().isEmpty())
				questList = new ArrayList<Question>();
			for (Question q : pojo.getQuestions()) {				
				questList.add(q);				
			}
			for(int i=questList.size();i<pojo.getNo_of_qus();i++){
				questList.add(new Question());
			}
			return "fill";
		} else if (action.equals("save")) {		
			Set<Question> qs = new HashSet<Question>();
			for (Question q : questList) {
				if(!q.getQus().isEmpty()&&q.getQus()!=null){
					q.setCreated_by(userPojo.getUSER_ID().toString());
					q.setIs_active("Y");
					qs.add(q);					
				}
			}
			pojo.setQuestions(qs);
			pojo.setNo_of_qus(qs.size());
			HibernateSessionFactory.getSession().clear();
			examDao.insert(pojo);
			addActionMessage("Questions sucessfully added");
			return "added";
		}else if(action.equals("showp")){
			System.out.println("called asdasdas");
			for (Question q : pojo.getQuestions()) {				
				questList.add(q);				
			}
			return "show";
		}
		else
			return "error";
	}

}
