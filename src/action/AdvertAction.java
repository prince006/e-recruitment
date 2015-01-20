package action;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javassist.runtime.Desc;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;

import pojo.Advert;
import pojo.UserPojo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AdvertDao;


public class AdvertAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 2589627891189151467L;
	private Integer ID;//	NUMBER
	private String SUBJECT;//	VARCHAR
	private String DESC;//	VARCHAR
	private String IS_ACTIVE;//	VARCHAR
	private String CREATED_BY;//	VARCHAR
	private Timestamp CREATED_ON;//	TIMESTAMP	
	private AdvertDao advertDao;
	private List<Advert> advertList;
	private String action;
	private String url;
	private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName; 
	@SuppressWarnings("rawtypes")
	private Map session;
	
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public String getDESC() {
		return DESC;
	}
	public void setDESC(String dESC) {
		DESC = dESC;
	}
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
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public AdvertDao getAdvertDao() {
		return advertDao;
	}
	public void setAdvertDao(AdvertDao advertDao) {
		this.advertDao = advertDao;
	}
	public List<Advert> getAdvertList() {
		return advertList;
	}
	public void setAdvertList(List<Advert> advertList) {
		this.advertList = advertList;
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
	
	public String execute() throws Exception 
	{
		setSession(ActionContext.getContext().getSession());
    	UserPojo pojo = (UserPojo) session.get("user");
    	if(pojo==null)
    	{
    		addActionError("Unauthorized access not allowed.");
    		return ERROR;
    	}
    	return SUCCESS;
	}
	public String create() throws Exception 
	{
		setSession(ActionContext.getContext().getSession());
    	UserPojo userPojo = (UserPojo) session.get("user");
    	if(userPojo==null)
    	{
    		addActionError("Unauthorized access not allowed.");
    		return ERROR;
    	}
    	else
    	{
    		if(action!=null && action.equalsIgnoreCase("save"))
    		{
    			Advert pojo = new Advert();
    			pojo.setSubject(SUBJECT);
    			pojo.setDescription(DESC);
    			pojo.setCreated_by(userPojo.getUSER_ID().toString());
    			pojo.setIs_active("Y");
    			String filePath;
    			try{
                    filePath = "C:/Users/Public/Documents/";  // Path where uploaded file will be stored
                    System.out.println("Server path:" + filePath); // check your path in console
                    File fileToCreate = new File(filePath,uploadFileFileName);// Create file name  same as original
                    FileUtils.copyFile(uploadFile, fileToCreate); // Just copy temp file content to this file      
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                        addActionError(e.getMessage());
                        return INPUT;         
                    }
                pojo.setUrl(filePath+uploadFileFileName);    
       			boolean save = advertDao.insert(pojo);
    			if(save)
    			{
    				addActionMessage("Record saved.");
    				return SUCCESS;
    			}
    			else
    			{
    				addActionMessage("Record not saved.");
    			}
    		}
		}	
		return "input";
	}
	
	public String edit() throws Exception 
	{
		setSession(ActionContext.getContext().getSession());
    	UserPojo userPojo = (UserPojo) session.get("user");
    	if(userPojo==null)
    	{
    		addActionError("Unauthorized access not allowed.");
    		return ERROR;
    	}
    	else
    	{
    		if(action!=null && action.equalsIgnoreCase("edit"))
    		{
    			Advert result = advertDao.search(ID);
    			if(result!=null)
    			{
    				SUBJECT=result.getSubject();
    				DESC= result.getDescription();
    				IS_ACTIVE=result.getIs_active();    				
    				return INPUT;
    			}
    			else
    			{
    				addActionMessage("Invalid record. Please contact to administrator.");
    			}
    		}
    		else if(action!=null && action.equalsIgnoreCase("save"))
    		{
    			Advert pojo = advertDao.search(ID);
    			if(pojo!=null)
    			{
    			pojo.setSubject(SUBJECT);
    			pojo.setDescription(DESC);  
    			pojo.setIs_active(IS_ACTIVE);
    			boolean save = advertDao.update(pojo);
    				if(save)
    				{
    					addActionMessage("Record updated.");
    				}
    				else
    				{
    					addActionMessage("Record not updated.");
    				}
    			}
    			else
    			{
    				addActionMessage("System error. Please contact to administrator.");
    			}
    			return SUCCESS;
    		}
		}
		
		return INPUT;
	}
	
	public String search() throws Exception 
	{
		setSession(ActionContext.getContext().getSession());
    	UserPojo userPojo = (UserPojo) session.get("user");
    	if(userPojo==null)
    	{
    		addActionError("Unauthorized access not allowed.");
    		return ERROR;
    	}
    	else
    	{
    		if(action!=null && action.equalsIgnoreCase("search"))
    		{
    			if(!SUBJECT.isEmpty() || !DESC.isEmpty()){
    			Advert pojo = new Advert();
    			pojo.setSubject(SUBJECT);
    			pojo.setDescription(DESC);    			   
    			advertList=advertDao.search(pojo);
   				return SUCCESS;
   				}else
   					addActionError("Please enter atleast one Key!");
    		}
		}		
		return "input";
	}

	public String advertList() throws Exception 
	{
		setSession(ActionContext.getContext().getSession());
    	UserPojo userPojo = (UserPojo) session.get("user");
    	if(userPojo==null)
    	{
    		addActionError("Unauthorized access not allowed.");
    		return ERROR;
    	}		
    	advertList=advertDao.list();    	
		return "list";
	}
	public String liveadvert() throws Exception 
	{    	
		Advert advert= advertDao.generateRandomAdvert();
		setSUBJECT(advert.getSubject());
		setDESC(advert.getDescription());
		setUrl(advert.getUrl());
		return SUCCESS;
	}

	
}
