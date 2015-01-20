package action;

import hibernate.HibernateSessionFactory;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Exam;
import pojo.Job;
import pojo.Resume;
import pojo.Resume_Experience;
import pojo.Resume_qualification;
import pojo.UserPojo;
import utility.Pdf;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import dao.ResumeDao;
import dao.UserDAO;

public class ResumeAction extends ActionSupport implements SessionAware,
		ModelDriven<List<Resume_qualification>>, Preparable {
	private static final long serialVersionUID = 2589627891189151467L;

	private Integer resume_no;
	private String title;
	private String first_name;
	private String last_name;
	private String c_address;
	private String p_address;
	private String mobile_no;
	private String email;
	private String gender;
	private String is_married;
	private String remarks;
	private String is_active;
	private String skills;
	private String created_by;
	private List<Resume_qualification> rQualification;
	private List<Resume_Experience> rExperiences;
	private List<Resume> resumes;
	private Double rating,exp;
	private Timestamp created_on;
	private String action;
	
	private String job_title1, job_title2;
	private String job_profile1, job_profile2;
	private String company1, company2;
	private String location1, location2;
	private String job_responsibility1, job_responsibility2;
	private String from_date1, from_date2;
	private String to_date1, to_date2;
	private Integer resume_exp_no1,resume_exp_no2;
	private InputStream fileStream;
	private String test;

	@SuppressWarnings("rawtypes")
	private Map session;
	private ResumeDao resumeDao;
	private UserDAO userDAO;
	
	
	
	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getExp() {
		return exp;
	}

	public void setExp(Double exp) {
		this.exp = exp;
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}

	public void setFileStream(InputStream arg) {
			fileStream = arg;		
	}
	
	public InputStream getFileStream() {
		return fileStream;	
	}

	public Integer getResume_exp_no1() {
		return resume_exp_no1;
	}

	public void setResume_exp_no1(Integer resume_exp_no1) {
		this.resume_exp_no1 = resume_exp_no1;
	}

	public Integer getResume_exp_no2() {
		return resume_exp_no2;
	}

	public void setResume_exp_no2(Integer resume_exp_no2) {
		this.resume_exp_no2 = resume_exp_no2;
	}

	public Integer getResume_no() {
		return resume_no;
	}

	public void setResume_no(Integer resume_no) {
		this.resume_no = resume_no;
	}

	public List<Resume_Experience> getrExperiences() {
		return rExperiences;
	}

	public void setrExperiences(List<Resume_Experience> rExperiences) {
		this.rExperiences = rExperiences;
	}

	public String getJob_title1() {
		return job_title1;
	}

	public void setJob_title1(String job_title1) {
		this.job_title1 = job_title1;
	}

	public String getJob_title2() {
		return job_title2;
	}

	public void setJob_title2(String job_title2) {
		this.job_title2 = job_title2;
	}

	public String getJob_profile1() {
		return job_profile1;
	}

	public void setJob_profile1(String job_profile1) {
		this.job_profile1 = job_profile1;
	}

	public String getJob_profile2() {
		return job_profile2;
	}

	public void setJob_profile2(String job_profile2) {
		this.job_profile2 = job_profile2;
	}

	public String getCompany1() {
		return company1;
	}

	public void setCompany1(String company1) {
		this.company1 = company1;
	}

	public String getCompany2() {
		return company2;
	}

	public void setCompany2(String company2) {
		this.company2 = company2;
	}

	public String getLocation1() {
		return location1;
	}

	public void setLocation1(String location1) {
		this.location1 = location1;
	}

	public String getLocation2() {
		return location2;
	}

	public void setLocation2(String location2) {
		this.location2 = location2;
	}

	public String getJob_responsibility1() {
		return job_responsibility1;
	}

	public void setJob_responsibility1(String job_responsibility1) {
		this.job_responsibility1 = job_responsibility1;
	}

	public String getJob_responsibility2() {
		return job_responsibility2;
	}

	public void setJob_responsibility2(String job_responsibility2) {
		this.job_responsibility2 = job_responsibility2;
	}

	public String getFrom_date1() {
		return from_date1;
	}

	public void setFrom_date1(String from_date1) {
		this.from_date1 = from_date1;
	}

	public String getFrom_date2() {
		return from_date2;
	}

	public void setFrom_date2(String from_date2) {
		this.from_date2 = from_date2;
	}

	public String getTo_date1() {
		return to_date1;
	}

	public void setTo_date1(String to_date1) {
		this.to_date1 = to_date1;
	}

	public String getTo_date2() {
		return to_date2;
	}

	public void setTo_date2(String to_date2) {
		this.to_date2 = to_date2;
	}

	public List<Resume_qualification> getrQualification() {
		return rQualification;
	}

	public void setrQualification(List<Resume_qualification> rQualification) {
		this.rQualification = rQualification;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public String getP_address() {
		return p_address;
	}

	public void setP_address(String p_address) {
		this.p_address = p_address;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIs_married() {
		return is_married;
	}

	public void setIs_married(String is_married) {
		this.is_married = is_married;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public ResumeDao getResumeDao() {
		return resumeDao;
	}

	public void setResumeDao(ResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}

	public ResumeAction() {
		action="null";
	}

	public String execute() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		return SUCCESS;
	}

	public String create() throws Exception {
		int flag = 0, trueSize = 0;
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {
			if (action != null && action.equalsIgnoreCase("save")) {
				Resume resume = new Resume();
				resume.setC_address(c_address);
				resume.setEmail(email);
				resume.setFirst_name(first_name);
				resume.setGender(gender);
				resume.setIs_married(is_married);
				resume.setLast_name(last_name);
				resume.setMobile_no(mobile_no);
				resume.setP_address(p_address);
				resume.setRemarks(remarks);
				resume.setSkills(skills);
				resume.setExp(exp);
				resume.setRating(0.0);
				resume.setTitle(title);
				resume.setIs_active(is_active);
				resume.setCreated_by(userPojo.getUSER_ID().toString());
				for (Resume_qualification rq : rQualification) {
					if (!rq.getQualification().isEmpty()
							&& rq.getQualification() != null) {
						trueSize++;
						rq.setResume(resume);
						boolean save = resumeDao.insert(rq);
						if (save) {
							flag++;
						}
					}
				}
				if (!job_title1.isEmpty() && job_title1 != null) {
					Resume_Experience r1 = new Resume_Experience(job_title1,
							job_profile1, job_responsibility1, company1,
							location1, from_date1, to_date1, resume);
					resumeDao.insert(r1);
				}
				if (!job_title2.isEmpty() && job_title2 != null) {
					Resume_Experience r2 = new Resume_Experience(job_title2,
							job_profile2, job_responsibility2, company2,
							location2, from_date2, to_date2, resume);
					resumeDao.insert(r2);
				}
				if (flag == trueSize) {
					ActionContext.getContext().getSession().put("resume","created");
					addActionMessage("Record saved.");
					return SUCCESS;
				} else {
					addActionMessage("Record not saved.");
				}

			}
		}

		return "input";
	}

	public String edit() {
	{
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {			
                 Resume result=resumeDao.searchByUser(userPojo);
                 resume_no=result.getResume_no();
                 title=result.getTitle();
	           	 first_name=result.getFirst_name();
	           	 last_name=result.getLast_name();
	           	 c_address=result.getC_address();
	           	 p_address=result.getP_address();
	           	 mobile_no=result.getMobile_no();
	           	 email=result.getEmail();
	           	 gender=result.getGender();
	           	 is_married=result.getIs_married();
	           	 remarks=result.getRemarks();
	           	 is_active=result.getIs_active();
	           	 exp=result.getExp();
	           	 skills=result.getSkills();
	           	 rQualification=resumeDao.getQualification(result);
	           	 if(rQualification.size()<4)
	           	 {
	           		 for (int i = rQualification.size()+1; i <=4; i++) {
	           			rQualification.add(new Resume_qualification());
					}
	           	 }
	           	rExperiences=resumeDao.getExperience(result);
	           	int i=0;
                if(rExperiences.size()>0 && rExperiences.size()<=2)
                {
                	resume_exp_no1=rExperiences.get(0).getResume_exp_no();
                	job_title1 = rExperiences.get(0).getJob_title();
					job_profile1=rExperiences.get(0).getJob_profile();
					job_responsibility1=rExperiences.get(0).getJob_responsibility();
					company1=rExperiences.get(0).getCompany();
					location1=rExperiences.get(0).getLocation();
					from_date1=rExperiences.get(0).getFrom_date();
					to_date1=rExperiences.get(0).getTo_date();
					if(rExperiences.size()==2){
						resume_exp_no2=rExperiences.get(0).getResume_exp_no();
						job_title2 = rExperiences.get(1).getJob_title();
						job_profile2=rExperiences.get(1).getJob_profile();
						job_responsibility2=rExperiences.get(1).getJob_responsibility();
						company2=rExperiences.get(1).getCompany();
						location2=rExperiences.get(1).getLocation();
						from_date2=rExperiences.get(1).getFrom_date();
						to_date2=rExperiences.get(1).getTo_date();
					}
                }
	           	 
			}
		return INPUT;
		}
	}
	public String save(){
			int flag = 0, trueSize = 0;
			setSession(ActionContext.getContext().getSession());
			UserPojo userPojo = (UserPojo) session.get("user");
			if (userPojo == null) {
				addActionError("Unauthorized access not allowed.");
				return ERROR;
			} else {
				if (action != null && action.equalsIgnoreCase("save")) {
					Resume resume=resumeDao.searchByUser(userPojo);
					resume.setC_address(c_address);
					resume.setEmail(email);
					resume.setFirst_name(first_name);
					resume.setGender(gender);
					resume.setIs_married(is_married);
					resume.setLast_name(last_name);
					resume.setMobile_no(mobile_no);
					resume.setP_address(p_address);
					resume.setRemarks(remarks);
					resume.setTitle(title);
					resume.setIs_active(is_active);
					resume.setExp(exp);
					resume.setSkills(skills);
					resume.setCreated_by(userPojo.getUSER_ID().toString());
					System.out.println(resume_no);
					for (Resume_qualification rq : rQualification) {
						
						if (!rq.getQualification().isEmpty() && rq.getQualification() != null) {
							trueSize++;							
							rq.setResume(resume);
							boolean save = resumeDao.update(rq);
							if (save) {
								flag++;
							}
							System.out.println("value" + rq.getQualification());
				}
					}
					if (!job_title1.isEmpty() && job_title1 != null) {
						Resume_Experience r1 = new Resume_Experience(resume_exp_no1,job_title1,
								job_profile1, job_responsibility1, company1,
								location1, from_date1, to_date1, resume);
						resumeDao.update(r1);
					}
					if (!job_title2.isEmpty() && job_title2 != null) {
						Resume_Experience r2 = new Resume_Experience(resume_exp_no2,job_title2,
								job_profile2, job_responsibility2, company2,
								location2, from_date2, to_date2, resume);
						resumeDao.update(r2);
					}
					if (flag == trueSize) {
						addActionMessage("Record Updated.");
						return SUCCESS;
					} else {
						addActionMessage("Record not Updated.");
					}
				}
			}			
		return INPUT;
	}
	@Override
	public List<Resume_qualification> getModel() {
		// TODO Auto-generated method stub
		return rQualification;
	}

	@Override
	public void prepare() throws Exception {

		rQualification = new ArrayList<Resume_qualification>();
		rQualification.add(new Resume_qualification());
		rQualification.add(new Resume_qualification());
		rQualification.add(new Resume_qualification());
		rQualification.add(new Resume_qualification());
		System.out.println("in prepare");

	}
	
	public String preview() throws Exception {
		if (action != null && action.equalsIgnoreCase("dwResume")) {
			try{
				setSession(ActionContext.getContext().getSession());				
				new Pdf().createPDF(resumeDao.search(resume_no));
				fileStream = new DataInputStream(
				  new FileInputStream("Resume.pdf"));
			} catch (Exception ioEx) {
				ioEx.printStackTrace();
			}
		}else{
			try{
				setSession(ActionContext.getContext().getSession());
				UserPojo pojo = (UserPojo) session.get("user");
				new Pdf().getUserResumePdf(pojo);
				fileStream = new DataInputStream(
				  new FileInputStream("Resume.pdf"));
			} catch (Exception ioEx) {
				ioEx.printStackTrace();
			}				
		}	
		return "test-stream";
	}

	public String eexecute() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		return SUCCESS;
	}
	public String searchEResume() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}else{
			if(action.equalsIgnoreCase("search"))
			{
				Resume pojo=new Resume();
				pojo.setTitle(title);
				pojo.setFirst_name(first_name);
				pojo.setLast_name(last_name);
				pojo.setGender(gender);
				pojo.setIs_married(is_married);
				pojo.setRating(rating);
				pojo.setExp(exp);
				if(title.isEmpty() && first_name.isEmpty() && last_name.isEmpty() && gender.equals("0") &&is_married.equals("0")&&rating==null)
					return INPUT;
				resumes=resumeDao.search(pojo);
				if(!resumes.isEmpty())
					test="1";				
				return SUCCESS;
			}			
		}
		return INPUT;
	}
	public String saveR() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}else{			
			Integer Id=userPojo.getUSER_ID();
			UserPojo u1= new UserDAO().search(Id);
			Set<Resume> up=u1.getSaved_resume();
			up.add(resumeDao.search(resume_no));
			u1.setSaved_resume(up);
			boolean rslt=new UserDAO().insert(u1);
			if(rslt)
				addActionMessage("You have successfully saved Job ID :"
					+ resume_no);
			else
				addActionMessage("Sorry, Resume is already saved/Purchased , Please browse respective tabs ");

			resumes=resumeDao.listAll(userPojo.getUSER_ID());
			if(!resumes.isEmpty())
				test="1";	
		}
		return "list";
	}
	public String purchaseR() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}else{
			if(action !=null && action.equals("paysuccess")){
				String flag = (String) session.get("RtoPurchase");			
				if(flag.equals("1"))
					addActionMessage("You have successfully Purchased Resume ");
				else
					addActionMessage("Sorry, Resume is already saved/Purchased , Please browse respective tabs ");
				
				resumes=resumeDao.listPurchased(userPojo.getUSER_ID());
				if(!resumes.isEmpty())
					test="1";	
				return "list";
			}else{
				Integer Id=userPojo.getUSER_ID();
				UserPojo u1= userDAO.search(Id);
				Set<Resume> up=u1.getPurchased_resume();
				up.add(resumeDao.search(resume_no));
				u1.setPurchased_resume(up);
				boolean rslt= userDAO.insert(u1);
				String flag="0";
				if(rslt)
					flag="1";
				ActionContext.getContext().getSession().put("RtoPurchase",flag);				
				return "pay";
			}
		}
	}
	
	public String allEResume() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;			
		}
		resumes=resumeDao.listAll(userPojo.getUSER_ID());
		if(!resumes.isEmpty())
			test="1";	
		return "list";
	}
	
	public String viewSavedR() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;			
		}
		resumes=resumeDao.listSaved(userPojo.getUSER_ID());
		if(!resumes.isEmpty())
			test="1";	
		return "list";

	}
	public String viewPurchaseR() {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;			
		}
		resumes=resumeDao.listPurchased(userPojo.getUSER_ID());
		if(!resumes.isEmpty())
			test="1";	
		return "list";

	}
	
}
