package action;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javassist.runtime.Desc;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Advert;
import pojo.Job;
import pojo.Question;
import pojo.Resume;
import pojo.UserPojo;
import utility.Dates;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AdvertDao;
import dao.JobDao;
import dao.QuestDao;

public class JobAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 2589627891189151467L;
	private Integer job_no;// NUMBER
	private Integer exam_no;// NUMBER
	private String title;// VARCHAR
	private String description;// VARCHAR
	private Double max_exp;// VARCHAR
	private Double min_exp;// VARCHAR
	private Date expire_date;// VARCHAR
	private String is_active;// VARCHAR
	private String created_by;// VARCHAR
	private Timestamp created_on;// TIMESTAMP
	private JobDao jobDao;
	private List<Job> jobList;
	private List<Resume> resumes;
	private String action;
	private String expire_dat;// VARCHAR
	@SuppressWarnings("rawtypes")
	private Map session;
	private String test;
	private String pagetitle;
	private String link;
	
	private String skill_req;
	private String location;
	private String job_role;
	private String emp_type;
	private String fun_area;
	private String job_cat;
	private String is_saved;
	private String is_applied;
	

	public String getIs_saved() {
		return is_saved;
	}

	public void setIs_saved(String is_saved) {
		this.is_saved = is_saved;
	}

	public String getIs_applied() {
		return is_applied;
	}

	public void setIs_applied(String is_applied) {
		this.is_applied = is_applied;
	}

	public String getSkill_req() {
		return skill_req;
	}

	public void setSkill_req(String skill_req) {
		this.skill_req = skill_req;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJob_role() {
		return job_role;
	}

	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getFun_area() {
		return fun_area;
	}

	public void setFun_area(String fun_area) {
		this.fun_area = fun_area;
	}

	public String getJob_cat() {
		return job_cat;
	}

	public void setJob_cat(String job_cat) {
		this.job_cat = job_cat;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getExam_no() {
		return exam_no;
	}

	public void setExam_no(Integer exam_no) {
		this.exam_no = exam_no;
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}

	public String getPagetitle() {
		return pagetitle;
	}

	public void setPagetitle(String pagetitle) {
		this.pagetitle = pagetitle;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getExpire_dat() {
		return expire_dat;
	}

	public void setExpire_dat(String expire_dat) {
		this.expire_dat = expire_dat;
	}

	public Integer getJob_no() {
		return job_no;
	}

	public void setJob_no(Integer job_no) {
		this.job_no = job_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getMax_exp() {
		return max_exp;
	}

	public void setMax_exp(Double max_exp) {
		this.max_exp = max_exp;
	}

	public Double getMin_exp() {
		return min_exp;
	}

	public void setMin_exp(Double min_exp) {
		this.min_exp = min_exp;
	}

	public Date getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}

	public JobDao getJobDao() {
		return jobDao;
	}

	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
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

	public String execute() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo pojo = (UserPojo) session.get("user");
		if (pojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		if (pojo.getCATEGORY().equals("J"))
			return "jsuccess";
		else
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
				Job pojo = new Job();
				pojo.setTitle(title);
				pojo.setDescription(description);
				pojo.setExpire_date(Dates.getDate(expire_dat));
				pojo.setMin_exp(min_exp);
				pojo.setMax_exp(max_exp);
				pojo.setSkill_req(skill_req);
				pojo.setLocation(location);
				pojo.setEmp_type(emp_type);
				pojo.setJob_cat(job_cat);
				pojo.setJob_role(job_role);
				pojo.setFun_area(fun_area);				
				pojo.setCreated_by(userPojo.getUSER_ID().toString());
				pojo.setIs_active("Y");
				boolean save = jobDao.insert(pojo);
				System.out.println(expire_dat);
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
				Job result = jobDao.search(job_no);
				if (result != null) {
					title = result.getTitle();
					description = result.getDescription();
					expire_dat = result.getExpire_date().toString();
					skill_req = result.getSkill_req();
					location= result.getLocation();
					emp_type= result.getEmp_type();
					job_cat= result.getJob_cat();
					job_role= result.getJob_role();
					fun_area= result.getFun_area();				
					max_exp = result.getMax_exp();
					min_exp = result.getMin_exp();
					is_active = result.getIs_active();
					return INPUT;
				} else {
					addActionMessage("Invalid record. Please contact to administrator.");
				}
			} else if (action != null && action.equalsIgnoreCase("save")) {
				Job pojo = jobDao.search(job_no);
				if (pojo != null) {
					pojo.setTitle(title);
					pojo.setDescription(description);
					pojo.setExpire_date(Dates.getDate(expire_dat));
					pojo.setSkill_req(skill_req);
					pojo.setLocation(location);
					pojo.setEmp_type(emp_type);
					pojo.setJob_cat(job_cat);
					pojo.setJob_role(job_role);
					pojo.setFun_area(fun_area);				
					pojo.setMax_exp(max_exp);
					pojo.setMin_exp(min_exp);					
					pojo.setIs_active(is_active);
					boolean save = jobDao.update(pojo);
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
		boolean flag=true;
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {
			if (action != null && action.equalsIgnoreCase("search")) {
				Job pojo = new Job();
				pojo.setTitle(title);
				pojo.setDescription(description);
				pojo.setExpire_date(expire_date);
				pojo.setSkill_req(skill_req);
				pojo.setLocation(location);
				pojo.setEmp_type(emp_type);
				pojo.setJob_cat(job_cat);
				pojo.setJob_role(job_role);
				pojo.setFun_area(fun_area);
				pojo.setMax_exp(max_exp);
				pojo.setMin_exp(min_exp);
				if(title.isEmpty() && description.isEmpty()&& expire_dat.isEmpty()&&skill_req.isEmpty()&&location.isEmpty()&&emp_type.isEmpty()&&job_cat.isEmpty()&&job_role.isEmpty()&&fun_area.isEmpty()&&max_exp==null&&min_exp==null)
					flag=false;				
				pagetitle = "Available Jobs";
				test="1";
				if (userPojo.getCATEGORY().equals("J"))
				{
					if(!flag)
						return "jinput";
					jobList = jobDao.search(pojo);
					return "jlist";
				}
				else if (userPojo.getCATEGORY().equals("A"))
				{
					if(!flag)
						return "ainput";
					jobList = jobDao.search(pojo);
					return "alist";
				}
				else
				{	if(!flag)
					return "input";
					jobList = jobDao.search(pojo,userPojo);
					return SUCCESS;
				}
			}		
		if (userPojo.getCATEGORY().equals("J"))
			return "jinput";
		else if (userPojo.getCATEGORY().equals("A")) {
			return "ainput";
		}
		else
			return "input";
		}
	}
	
	public String getAlljobList() throws Exception 
	{
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) 
		{
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		pagetitle = "Created Jobs";
		if (userPojo.getCATEGORY().equals("A")) 
		{jobList = jobDao.listJobs();
				if (jobList.size() > 0)
					{
					test = "1";
					}
		 else {addActionMessage("No Jobs found");
				return INPUT;
		 		}
				return "list";}
		else {
			return ERROR;
		}
	}
	
	

	public String jobList() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		pagetitle = "Available Jobs";
		if (userPojo.getCATEGORY().equals("J")) {
			jobList = jobDao.listUnapplied(userPojo.getUSER_ID());
			if (jobList.size() > 0)
				test = "1";
			return "jlist";
		} else {
			jobList = jobDao.list(userPojo);			
			if (jobList.size() > 0)
				test = "1";
			return "list";
		}
	}
	public String viewDetailedJob() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		Job result = jobDao.search(job_no);
		is_applied=jobDao.isJobApplied(userPojo.getUSER_ID(),job_no);
		is_saved=jobDao.isJobSaved(userPojo.getUSER_ID(),job_no);
		if (result != null) {
			title = result.getTitle();
			description = result.getDescription();
			expire_dat = result.getExpire_date().toString();
			skill_req = result.getSkill_req();
			location= result.getLocation();
			emp_type= result.getEmp_type();
			job_cat= result.getJob_cat();
			job_role= result.getJob_role();
			fun_area= result.getFun_area();				
			max_exp = result.getMax_exp();
			min_exp = result.getMin_exp();
			is_active = result.getIs_active();
		} else {
			addActionMessage("Invalid record. Please contact to administrator.");
		}		
		return "details";
	}
	

	public String preferedJob() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		pagetitle = "Available Jobs";		
			jobList = jobDao.prefferedJob(userPojo);
			if (jobList.size() > 0)
				test = "1";
			return "jlist";		 
	}
	public String apply() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {
			if (action != null && action.equalsIgnoreCase("apply")) {
				Job job = jobDao.search(job_no);
				Set<UserPojo> up = job.getApplicants();
				up.add(userPojo);
				job.setApplicants(up);
				jobDao.insert(job);
				jobList = jobDao.listUnapplied(userPojo.getUSER_ID());
				addActionMessage("You have successfully applied for Job ID :"
						+ job_no);
			} else if (action != null && action.equalsIgnoreCase("save")) {
				Job job = jobDao.search(job_no);
				Set<UserPojo> up = job.getSaveJob();
				up.add(userPojo);
				job.setSaveJob(up);
				boolean rslt = jobDao.insert(job);
				jobList = jobDao.listUnapplied(userPojo.getUSER_ID());
				if (rslt)
					addActionMessage("You have successfully saved Job ID :"
							+ job_no);
				else
					addActionMessage("Sorry, Job is already saved, Please browse saved Jobs ");
			}
			if (jobList.size() > 0)
				test = "1";
		}
		return SUCCESS;
	}

	public String viewSavedJob() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		pagetitle = "Saved Jobs";
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}

		jobList = jobDao.viewSavedJob(userPojo.getUSER_ID());
		if (jobList.size() > 0)
			test = "1";
		return "list";
	}

	public String viewApplicants() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		pagetitle = "Job Applicants";
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		resumes = jobDao.viewApplicants(job_no);
		if (resumes.size() > 0)
			test = "1";
		return "list";
	}

	public String clearedUser() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		pagetitle = "User Cleared the Exam";
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}

		resumes = jobDao.viewPAssedResume(exam_no);
		if (resumes.size() > 0)
			test = "1";
		return "list";
	}

	public String viewAppliedJob() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		pagetitle = "Applied Jobs";
		jobList = jobDao.viewAppliedJob(userPojo.getUSER_ID());
		if (jobList.size() > 0)
			test = "1";
		return "list";
	}
}
