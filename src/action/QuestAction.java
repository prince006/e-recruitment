package action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javassist.runtime.Desc;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Advert;
import pojo.Question;
import pojo.UserPojo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AdvertDao;
import dao.QuestDao;

public class QuestAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 2589627891189151467L;
	private Integer qus_no;// NUMBER
	private String qus;// VARCHAR
	private String ansa;// VARCHAR
	private String ansb;// VARCHAR
	private String ansc;// VARCHAR
	private String ansd;// VARCHAR
	private String correctans;// VARCHAR
	private String is_active;// VARCHAR
	private String created_by;// VARCHAR
	private Timestamp created_on;// TIMESTAMP
	private QuestDao questDao;
	private List<Question> questList;
	private String size;
	private String action;
	@SuppressWarnings("rawtypes")
	private Map session;

	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getQus_no() {
		return qus_no;
	}

	public void setQus_no(Integer qus_no) {
		this.qus_no = qus_no;
	}

	public String getQus() {
		return qus;
	}

	public String getCorrectans() {
		return correctans;
	}

	public void setCorrectans(String correctans) {
		this.correctans = correctans;
	}

	public void setQus(String qus) {
		this.qus = qus;
	}

	public String getAnsa() {
		return ansa;
	}

	public void setAnsa(String ansa) {
		this.ansa = ansa;
	}

	public String getAnsb() {
		return ansb;
	}

	public void setAnsb(String ansb) {
		this.ansb = ansb;
	}

	public String getAnsc() {
		return ansc;
	}

	public void setAnsc(String ansc) {
		this.ansc = ansc;
	}

	public String getAnsd() {
		return ansd;
	}

	public void setAnsd(String ansd) {
		this.ansd = ansd;
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

	public String execute() throws Exception {
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
			if (action != null && action.equalsIgnoreCase("save")) {
				Question pojo = new Question();
				pojo.setQus(qus);
				pojo.setAnsa(ansa);
				pojo.setAnsb(ansb);
				pojo.setAnsc(ansc);
				pojo.setAnsd(ansd);
				pojo.setCorrectans(correctans);
				pojo.setIs_active("Y");
				pojo.setCreated_by(userPojo.getUSER_ID().toString());
				boolean save = questDao.insert(pojo);
				if (save) {
					addActionMessage("Record saved.");
					return SUCCESS;
				} else {
					addActionMessage("Record not saved.");
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
			if (action != null && action.equalsIgnoreCase("edit")) {
				Question result = questDao.search(qus_no);
				if (result != null) {
					qus = result.getQus();
					ansa = result.getAnsa();
					ansb = result.getAnsb();
					ansc = result.getAnsc();
					ansd = result.getAnsd();
					correctans=result.getCorrectans();
					is_active = result.getIs_active();
					return INPUT;
				} else {
					addActionMessage("Invalid record. Please contact to administrator.");
				}
			} else if (action != null && action.equalsIgnoreCase("save")) {
				Question pojo = questDao.search(qus_no);
				if (pojo != null) {
					pojo.setQus(qus);
					pojo.setAnsa(ansa);
					pojo.setAnsb(ansb);
					pojo.setAnsc(ansc);
					pojo.setAnsd(ansd);
					pojo.setCorrectans(correctans);
					pojo.setCreated_by(userPojo.getUSER_ID().toString());
					pojo.setIs_active(is_active);
					boolean save = questDao.update(pojo);
					if (save) {
						addActionMessage("Record updated.");
					} else {
						addActionMessage("Record not updated.");
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
				if(!qus.isEmpty() || !ansa.isEmpty() || !ansb.isEmpty()|| !ansc.isEmpty()|| !ansd.isEmpty()|| !correctans.equals("0")){
					Question pojo = new Question();
					pojo.setQus(qus);
					pojo.setAnsa(ansa);
					pojo.setAnsb(ansb);
					pojo.setAnsc(ansc);
					pojo.setAnsd(ansd);
					pojo.setCorrectans(correctans);
					questList = questDao.search(pojo,userPojo);
					return SUCCESS;					
				}else
					addActionError("Please enter atleast one Key!");
			}
		}
		return "input";
	}

	public String questList() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		questList = questDao.listAdminQuestion();
		if(questList.size()>0)
			size="nonzero";
		return "list";
	}

}
