package action;

import java.util.List;
import pojo.ContactUsPojo;
import java.util.Map;
import dao.ContactUsDao;

import org.apache.struts2.interceptor.SessionAware;

import pojo.ContactUsPojo;
import pojo.Job;
import pojo.UserPojo;
import dao.ContactUsDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ContactUsAction extends ActionSupport implements SessionAware
{
	ContactUsDao conDao=new ContactUsDao();
	private static final long serialVersionUID = -6288588656946058874L;
	ContactUsPojo contact=new ContactUsPojo();
	ContactUsDao condao=new ContactUsDao();
	private String name;
	private String email;
	private String message;
	private String action;
	private Map session;
	private String pagetitle;
	private List<ContactUsPojo> contacMessageList;
	
	
	
	

	public List<ContactUsPojo> getContacMessageList() {
		return contacMessageList;
	}

	public void setContacMessageList(List<ContactUsPojo> contacMessageList) {
		this.contacMessageList = contacMessageList;
	}

	public String getPagetitle() {
		return pagetitle;
	}

	public void setPagetitle(String pagetitle) {
		this.pagetitle = pagetitle;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws Exception 
	{
		return SUCCESS;
	}
	
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String contactUs()
	{
		if (action != null && action.equalsIgnoreCase("Send")) {
			
			
			contact.setEmail(email);
			contact.setName(name);
			contact.setYourMessage(message);
									
			boolean save = condao.contactUsSubmit(contact);
			if (save){
				addActionMessage("Thanks for your opinion. You will be contacted soon.....");
				return SUCCESS;
			}
			else
				addActionMessage("Sorry for inconvenience... but your information could not be saved");
			
		}

		return INPUT;
	}
	
	public String getAllContacts() throws Exception 
	{
		String test="0";
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) 
		{
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		pagetitle = "Available Contacts and Feedback";
		if (userPojo.getCATEGORY().equals("A")) 
		{
			contacMessageList = conDao.getContactLists();
				if (contacMessageList.size() > 0)
					{
					test = "1";
					}
		 else {addActionMessage("No Messages found");
				return INPUT;
		 		}
				return "list";}
		else {
			return ERROR;
		}
	}
	
}
