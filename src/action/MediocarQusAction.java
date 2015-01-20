package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Exam;
import pojo.Question;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ExamDao;

public class MediocarQusAction extends ActionSupport implements SessionAware{
    
	@SuppressWarnings("rawtypes") 
	private Map session;
	private Integer exam_no;
	private ExamDao examDao;
	private String action;
	
	

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public ExamDao getExamDao() {
		return examDao;
	}

	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}

	public Integer getExam_no() {
		return exam_no;
	}

	public void setExam_no(Integer exam_no) {
		this.exam_no = exam_no;
	}

	public Map getSession() {
		return session;
	}
    
	public void setSession(Map session) {
		this.session = session;
	}
	
	@Override
	public String execute() throws Exception {
		Exam e= examDao.search(exam_no);
		ActionContext.getContext().getSession().put("exam", e);
		ActionContext.getContext().getSession().put("action",action);
		return SUCCESS;
	}
	

}
