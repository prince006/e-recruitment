package action;

import java.util.Map;
import utility.*;

import org.apache.struts2.interceptor.SessionAware;

import pojo.UserPojo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import dao.ResumeDao;
import dao.UserDAO;

public class UserAction extends ActionSupport implements SessionAware {
	SendEmail email=new SendEmail();
	private String CATEGORY;// VARCHAR
	private String NAME;// VARCHAR
	private String ADDRESS;// VARCHAR
	private String CITY;// VARCHAR
	private String STATE;// VARCHAR
	private String EMAIL;// VARCHAR
	private String PASSWORD;// VARCHAR
	private String MOBILE;// VARCHAR
	private String action;
	private String NEWPASS;// VARCHAR
	private static final long serialVersionUID = -2334956962083879224L;

	@SuppressWarnings("rawtypes")
	private Map session;

	private UserDAO userDAO;

	public String getNEWPASS() {
		return NEWPASS;
	}

	public void setNEWPASS(String nEWPASS) {
		NEWPASS = nEWPASS;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getMOBILE() {
		return MOBILE;
	}

	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}

	public String login() throws Exception {
		if (action != null && action.equalsIgnoreCase("login")) {
			UserPojo userPojo = userDAO.getUserPojo(EMAIL, PASSWORD);
			if (userPojo != null) {
				if (userPojo.getIS_ACTIVE() != null	&& userPojo.getIS_ACTIVE().equalsIgnoreCase("Y")) {
					if(userPojo.getCATEGORY().equals("J"))
					{
						if(new ResumeDao().resumeCreation(userPojo)==false){
							ActionContext.getContext().getSession().put("resume","notcreated");
						}
					}
					ActionContext.getContext().getSession().put("user", userPojo);					
					return "home";
				} else
					addActionMessage("Inactive user. Please contact to administrator.");
			} else
				addActionMessage("Invalid user !!!");
		}
		else if (action != null && action.equalsIgnoreCase("Submit")) {
			
			UserPojo userPojo = userDAO.getUserPojo(EMAIL);
			if (userPojo != null) {
				email.send(EMAIL, userPojo.getMOBILE());
				addActionMessage("Your Password link has been sent to your mail");
				return SUCCESS;
			} else
				{
					return INPUT;
				}
		}
		return "login";
	}

	public String AuthencateUser() throws Exception
	{
		 Integer passcode = (int)(Math.random()*999999.0);
		   while(passcode<1000)
		   {
			   passcode = (int)(Math.random()*999999.0);
		   }
		System.out.println("Authenticate User Done.....");
		if (action != null && action.equalsIgnoreCase("UserAuthentication")) 
		{
			UserPojo userPojo = userDAO.getUserAuthenticate(EMAIL);
			if (userPojo != null) 
			{SmsLane sms=new SmsLane();
				
					userPojo.setIS_ACTIVE("Y");
					userPojo.setPASSWORD(String.valueOf(passcode));
					boolean save = userDAO.update(userPojo);
					if(save)
					{
						PASSWORD=String.valueOf(passcode);
						String response=sms.SMSSender("FYP", "9386044125", MOBILE, "Your Password is: "+PASSWORD, "WebSMS", "0");
						System.out.println("Data Activated");
						ActionContext.getContext().getSession().put("user", userPojo);
						return "success";
					}
				}
			} 
			else
			{
				addActionMessage("Invalid user !!!");
			}
		return "error";
	}
	
	
	
	
	
	
	public String resetPass() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		System.out.println(userPojo.getPASSWORD());
		System.out.println(PASSWORD);
		
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return "error";
		} else {
			if (action != null && action.equalsIgnoreCase("reset")) {
				if (userPojo.getPASSWORD().equals(PASSWORD)) {
					userPojo.setPASSWORD(NEWPASS);
					userDAO.update(userPojo);
					addActionMessage("Password Changed. Please Relogin to effect the changes");
					session.remove("user");
					return SUCCESS;
				} else
					{
					addActionMessage("Old Password didn't match, Try again.");
					return INPUT;
					}
				
			}
		}
		return "input";
	}

	public String logout() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return "error";
		}

		session.remove("user");
		ActionContext.getContext().getSession().remove("user");
		session.remove("resume");
		ActionContext.getContext().getSession().remove("resume");
		return "logout";
	}

	public String registration() throws Exception {
		if (action != null && action.equalsIgnoreCase("save")) {
			UserPojo userPojo = new UserPojo();
			userPojo.setADDRESS(ADDRESS);
			userPojo.setCATEGORY(CATEGORY);
			userPojo.setCITY(CITY);
			
			userPojo.setMOBILE(MOBILE);
			userPojo.setNAME(NAME);
			userPojo.setSTATE(STATE);
			
			if (!userDAO.search(EMAIL).isEmpty()) {
				addActionMessage("User with the same Email already exists. Please chose another!");
				return INPUT;
			}
			userPojo.setEMAIL(EMAIL);
						
			boolean save = userDAO.insert(userPojo);
			if (save){
				email.send(EMAIL, MOBILE);
				addActionMessage("You have been Registered Successfully   (Please Activate Your ID through registered email)");
			}
			else
				addActionMessage("Record not saved.");
			return SUCCESS;
		}

		return INPUT;
	}
}
