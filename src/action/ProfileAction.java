package action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.UserPojo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Failure;

import dao.UserDAO;

public class ProfileAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 2589627891189151467L;

	private Integer USER_ID;// NUMBER
	private String CATEGORY;// VARCHAR
	private String NAME;// VARCHAR
	private String ADDRESS;// VARCHAR
	private String CITY;// VARCHAR
	private String STATE;// VARCHAR
	private String EMAIL;// VARCHAR
	private String PASSWORD;// VARCHAR
	private String MOBILE;// VARCHAR
	private String IS_ACTIVE;// VARCHAR
	private String CREATED_BY;// VARCHAR
	private Timestamp CREATED_ON;// TIMESTAMP
	private String action;

	@SuppressWarnings("rawtypes")
	private Map session;

	private UserDAO userDAO;
	private List<UserPojo> userList;

	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}

	public void setIS_ACTIVE(String iS_ACTIVE) {
		IS_ACTIVE = iS_ACTIVE;
	}

	public String getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	public Timestamp getCREATED_ON() {
		return CREATED_ON;
	}

	public void setCREATED_ON(Timestamp cREATED_ON) {
		CREATED_ON = cREATED_ON;
	}

	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer uSER_ID) {
		USER_ID = uSER_ID;
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

	public List<UserPojo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserPojo> userList) {
		this.userList = userList;
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

	public String execute() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		return SUCCESS;
	}

	public String jsexecute() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		else if (userPojo.getCATEGORY().equalsIgnoreCase("E")) {
			return INPUT;
		}
		else return SUCCESS;
	}

	public String create() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {
			if (action != null && action.equalsIgnoreCase("save")) {
				if (!NAME.isEmpty() && !EMAIL.isEmpty() && !MOBILE.isEmpty()
						&& !CATEGORY.isEmpty() && !ADDRESS.isEmpty()
						&& !CITY.isEmpty()) {
					UserPojo userPojo1 = new UserPojo();
					userPojo1.setADDRESS(ADDRESS);
					userPojo1.setCATEGORY(CATEGORY);
					userPojo1.setCITY(CITY);
					userPojo1.setEMAIL(EMAIL);
					userPojo1.setMOBILE(MOBILE);
					userPojo1.setNAME(NAME);
					userPojo1.setSTATE(STATE);
					if (!userDAO.search(EMAIL).isEmpty()) {
						addActionMessage("User with the same Email already exists. Please chose another!");
						return "input";
					}
					boolean save = userDAO.insert(userPojo1);
					if (save) {
						addActionMessage("Record saved.");
						return SUCCESS;
					} else {
						addActionMessage("Record not saved.");
					}
				} else
					addActionMessage("Records cannot be blank !");
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
				UserPojo result = userDAO.search(USER_ID);
				if (result != null) {
					ADDRESS = result.getADDRESS();
					CATEGORY = result.getCATEGORY();
					CITY = result.getCITY();
					EMAIL = result.getEMAIL();
					MOBILE = result.getMOBILE();
					NAME = result.getNAME();
					STATE = result.getSTATE();
					IS_ACTIVE=result.getIS_ACTIVE();
					return INPUT;
				} else {
					addActionMessage("Invalid record. Please contact to administrator.");
				}
			} else if (action != null && action.equalsIgnoreCase("save")) {
				if (!NAME.isEmpty() && !EMAIL.isEmpty() && !MOBILE.isEmpty()
						&& !CATEGORY.isEmpty() && !ADDRESS.isEmpty()
						&& !CITY.isEmpty()) {
					UserPojo userPojo1 = userDAO.search(USER_ID);
					if (userPojo1 != null) {
						userPojo1.setADDRESS(ADDRESS);
						userPojo1.setCATEGORY(CATEGORY);
						userPojo1.setCITY(CITY);
						userPojo1.setEMAIL(EMAIL);
						userPojo1.setMOBILE(MOBILE);
						userPojo1.setNAME(NAME);
						userPojo1.setSTATE(STATE);
						userPojo1.setIS_ACTIVE(IS_ACTIVE);
						boolean save = userDAO.update(userPojo1);
						if (save) {
							addActionMessage("Record updated.");
							///userList = userDAO.list();
							return SUCCESS;
						} else {
							addActionMessage("Record not updated.");
						}
					} else
						addActionMessage("System error. Please contact to administrator.");
				} else {
					addActionMessage("Please input required fields");
					return INPUT;
				}
			}
			return INPUT;
		}
	}

	public String search() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {
			if (action != null && action.equalsIgnoreCase("search")) {
				if (!NAME.isEmpty() || !EMAIL.isEmpty() || !MOBILE.isEmpty()
						|| !ADDRESS.isEmpty() || !CATEGORY.equals("0")
						|| !CITY.isEmpty() || !STATE.isEmpty()) {

					UserPojo userPojo1 = new UserPojo();
					userPojo1.setADDRESS(ADDRESS);
					userPojo1.setCATEGORY(CATEGORY);
					userPojo1.setCITY(CITY);
					userPojo1.setEMAIL(EMAIL);
					userPojo1.setMOBILE(MOBILE);
					userPojo1.setNAME(NAME);
					userPojo1.setSTATE(STATE);
					userList = userDAO.search(userPojo1);
					return SUCCESS;
				} else
					addActionError("Please enter atleast one Key");
			}
		}
		return "input";
	}

	public String profileList() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}

		userList = userDAO.list();

		return "list";
	}

	public String jsViewProfile() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
		UserPojo uPojo = userDAO.search(userPojo.getUSER_ID());
		setUSER_ID(uPojo.getUSER_ID());
		setNAME(uPojo.getNAME());
		setADDRESS(uPojo.getADDRESS());
		setCITY(uPojo.getCITY());
		setSTATE(uPojo.getSTATE());
		setEMAIL(uPojo.getEMAIL());
		setMOBILE(uPojo.getMOBILE());
		return SUCCESS;
	}

	public String jseditProfile() throws Exception {
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		} else {
			if (action != null && action.equalsIgnoreCase("edit")) {
				UserPojo result = userDAO.search(userPojo.getUSER_ID());
				if (result != null) {
					USER_ID = result.getUSER_ID();
					ADDRESS = result.getADDRESS();
					CATEGORY = result.getCATEGORY();
					CITY = result.getCITY();
					EMAIL = result.getEMAIL();
					MOBILE = result.getMOBILE();
					NAME = result.getNAME();
					STATE = result.getSTATE();
					return INPUT;
				} else {
					addActionMessage("Invalid record. Please contact to administrator.");
				}
			} else if (action != null && action.equalsIgnoreCase("save")) {
				UserPojo userPojo1 = userDAO.search(userPojo.getUSER_ID());
				if (userPojo1 != null) {
					userPojo1.setADDRESS(ADDRESS);
					userPojo1.setCITY(CITY);
					userPojo1.setEMAIL(EMAIL);
					userPojo1.setMOBILE(MOBILE);
					userPojo1.setNAME(NAME);
					userPojo1.setSTATE(STATE);
					boolean save = userDAO.update(userPojo1);
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
}
