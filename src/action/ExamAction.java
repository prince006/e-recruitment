package action;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javassist.runtime.Desc;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Advert;
import pojo.Exam;
import pojo.Job;
import pojo.Question;
import pojo.QuestionExt;
import pojo.Resume;
import pojo.Resume_qualification;
import pojo.UserPojo;
import utility.Dates;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import dao.AdvertDao;
import dao.ExamDao;
import dao.JobDao;
import dao.QuestDao;
import dao.ResumeDao;

public class ExamAction extends ActionSupport implements SessionAware,
ModelDriven<List<QuestionExt>>, Preparable
 {
	private static final long serialVersionUID = 2589627891189151467L;
	private Integer exam_no;// NUMBER
	private Integer exam_time;// NUMBER
	private Integer min_pass;// NUMBER
	private Integer no_of_qus;// NUMBER
	private String is_active;// VARCHAR
	private String created_by;// VARCHAR
	private Timestamp created_on;// TIMESTAMP
	private String giveExam;
	private ExamDao examDao;
	private List<Exam> examList;
	private String action;
	private QuestDao questDao;
	private String test;
	private List<Question> questList;
	private List<QuestionExt> questExtList;
	private Integer qus_no;
	@SuppressWarnings("rawtypes")
	private Map session;
	private String targetDate;
	
	
	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public List<QuestionExt> getQuestExtList() {
		return questExtList;
	}

	public void setQuestExtList(List<QuestionExt> questExtList) {
		this.questExtList = questExtList;
	}

	public String getGiveExam() {
		return giveExam;
	}

	public void setGiveExam(String giveExam) {
		this.giveExam = giveExam;
	}

	public Integer getQus_no() {
		return qus_no;
	}

	public void setQus_no(Integer qus_no) {
		this.qus_no = qus_no;
	}

	public QuestDao getQuestDao() {
		return questDao;
	}

	public void setQuestDao(QuestDao questDao) {
		this.questDao = questDao;
	}

	public List<Question> getQuestList() {
		return questList;
	}

	public void setQuestList(List<Question> questList) {
		this.questList = questList;
	}

	public Integer getExam_no() {
		return exam_no;
	}

	public void setExam_no(Integer exam_no) {
		this.exam_no = exam_no;
	}

	public Integer getExam_time() {
		return exam_time;
	}

	public void setExam_time(Integer exam_time) {
		this.exam_time = exam_time;
	}

	public Integer getMin_pass() {
		return min_pass;
	}

	public void setMin_pass(Integer min_pass) {
		this.min_pass = min_pass;
	}

	public Integer getNo_of_qus() {
		return no_of_qus;
	}

	public void setNo_of_qus(Integer no_of_qus) {
		this.no_of_qus = no_of_qus;
	}

	public ExamDao getExamDao() {
		return examDao;
	}

	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public void setExamList(List<Exam> examList) {
		this.examList = examList;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	
	public String execute() throws Exception {
		
		setSession(ActionContext.getContext().getSession());
		UserPojo pojo = (UserPojo) session.get("user");
		if (pojo == null) {			
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		return SUCCESS;
	}
	public String executejs() throws Exception {
		
		setSession(ActionContext.getContext().getSession());
		UserPojo pojo = (UserPojo) session.get("user");
		if (pojo == null) {			
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		return SUCCESS;
	}
	public String create() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {
			if (action != null && action.equalsIgnoreCase("save")) 
			{
				if(min_pass<=no_of_qus)
				{
					Exam pojo = new Exam();
					pojo.setExam_time(exam_time);
					pojo.setMin_pass(min_pass);
					pojo.setNo_of_qus(no_of_qus);
					pojo.setCreated_by(userPojo.getUSER_ID().toString()+"-S");
					pojo.setIs_active("Y");
					boolean save = examDao.insert(pojo);
					if (save) {
						addActionMessage("Record saved.");
						return SUCCESS;
					} else {
						addActionMessage("Record not saved.");
					}
				}
				else {
					addActionMessage("Passing Marks can't be more than number of questions..");
					min_pass=no_of_qus;
				}
				
				
			}else if (action != null && action.equalsIgnoreCase("SaveAndPurchaseQus")) 
			{

				if(min_pass<=no_of_qus)
				{
					Exam pojo = new Exam();
					pojo.setExam_time(exam_time);
					pojo.setMin_pass(min_pass);
					pojo.setNo_of_qus(no_of_qus);
					pojo.setCreated_by(userPojo.getUSER_ID().toString()+"-P");
					pojo.setIs_active("Y");
					ActionContext.getContext().getSession().put("ExamtoCreate",pojo);
					return "payment";
				}else if (action != null && action.equalsIgnoreCase("paysuccess")) {
					Exam pojo = (Exam) session.get("ExamtoCreate");
					if(examDao.generateRandomExam(pojo))				
						addActionMessage("Payment sucessful,Questions has been added to the Exams.");
					else
						addActionMessage("Your request couldnt be processed, due to insufficient question in System, your money will be revert to your account within 24 hrs.");
					return SUCCESS;
				}
				else {
					addActionMessage("Passing Marks can't be more than number of questions..");
					min_pass=no_of_qus;
				}
				
				
			}
			
			
		}
		return "input";
	}

	public String edit() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {
			if (action != null && action.equalsIgnoreCase("edit")) 
			{
				Exam result = examDao.search(exam_no);
				if (result != null) {
					exam_time = result.getExam_time();
					min_pass = result.getMin_pass();
					no_of_qus = result.getNo_of_qus();
					is_active = result.getIs_active();
					return INPUT;
				} else {
					addActionMessage("Invalid record. Please contact to administrator.");
				}
			}
			else if (action != null && action.equalsIgnoreCase("editp")) 
			{
				Exam result = examDao.search(exam_no);
				if (result != null) {
					exam_time = result.getExam_time();
					min_pass = result.getMin_pass();
					no_of_qus = result.getNo_of_qus();
					is_active = result.getIs_active();
					return "inputp";
				} else {
					addActionMessage("Invalid record. Please contact to administrator.");
				}
			}
			else if (action != null && action.equalsIgnoreCase("save")) 
			{
				Exam pojo = examDao.search(exam_no);
				if (pojo != null) {
					
					if(min_pass<=no_of_qus)
					{
						pojo.setExam_time(exam_time);
						pojo.setMin_pass(min_pass);
						pojo.setNo_of_qus(no_of_qus);
						pojo.setIs_active(is_active);
						boolean save = examDao.update(pojo);
						if (save) {
							addActionMessage("Record updated.");
						} else {
							addActionMessage("Record not updated.");
						}
					}
					else {
						addActionMessage("NUmber of passing Questions Must be less...");
						min_pass=no_of_qus;
						return INPUT;
					}
					
					
				} else {
					addActionMessage("System error. Please contact to administrator.");
				}
				return SUCCESS;
			}
		}

		return INPUT;
	}

	public String search() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {
			if (action != null && action.equalsIgnoreCase("search")) {
				Exam pojo = new Exam();				
				pojo.setExam_time(exam_time);
				pojo.setMin_pass(min_pass);
				pojo.setNo_of_qus(no_of_qus);
				if(exam_time==null && min_pass==null && no_of_qus==null)
					return "input";
				examList = examDao.search(pojo);
				if(examList.size()>0)
					test="1";
				return SUCCESS;
			}
		}

		return "input";
	}

	public String examList() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}		
		examList = examDao.listEmpExams(userPojo);
		return "list";
	}
	public String pexamList() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}		
		examList = examDao.listPuchasedExams(userPojo);
		return "list";
	}
	public String allexamList() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}		
		examList = examDao.listUnClear(userPojo.getUSER_ID());
		if(examList.size()>0)
			test="1";
		return "list";
	}
	
	public String examListCleared() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}		
		examList = examDao.listCleared(userPojo.getUSER_ID());
		if(examList.size()>0)
			test="1";
		return "list";
	}
	
	

	@Override
	public List<QuestionExt> getModel() {
		// TODO Auto-generated method stub
		return questExtList;
	}

	@Override
	public void prepare() throws Exception {

		questExtList=new ArrayList<QuestionExt>();
		setSession(ActionContext.getContext().getSession());
		Exam e = (Exam) session.get("exam");
		action=(String)session.get("action");
		if(action !=null && action.equals("se")){		
			if(e !=null){
				for (int i = 0; i < e.getNo_of_qus(); i++) {
					questExtList.add(new QuestionExt());
				}				
			}				
		}		
	}
	
	public String giveExam() {		
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {				
				questExtList=new ArrayList<QuestionExt>();
				Exam result = examDao.search(exam_no);
				ActionContext.getContext().getSession().put("exam",result);
				ActionContext.getContext().getSession().put("action","se");
				exam_time = result.getExam_time();				
				min_pass = result.getMin_pass();
				no_of_qus = result.getNo_of_qus();
				System.out.println(exam_time);
				targetDate=Dates.getFormatedDate(exam_time);				
				System.out.println(targetDate);
				for (Question q : result.getQuestions()) {
					questExtList.add(new QuestionExt(q,""));
				}	
				examList = examDao.listUnClear(userPojo.getUSER_ID());
				giveExam="true";	
		}
		return SUCCESS;
	}
	public String examResult() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {			
				boolean rslt=examDao.validateExam(questExtList,min_pass);
			if(rslt){
					Exam exam = examDao.search(exam_no);
					Set<UserPojo> up=exam.getTakers();
					up.add(userPojo);
					exam.setTakers(up);
					examDao.insert(exam);
					Resume r = new ResumeDao().searchByUser(userPojo);					 
					if(r.getRating()==null){
						r.setRating(0.2);
					}else if(r.getRating()< 5.0){
						r.setRating(r.getRating()+0.2);
					}
					new ResumeDao().update(r);
					addActionMessage("Congratulations,You have successfully cleared Exam :"
							+ exam_no);	
				}else{
					addActionMessage("Sorry, you could not clear Exam :"
							+ exam_no);
				}
			}						
		return SUCCESS;
	}
	
	
}
