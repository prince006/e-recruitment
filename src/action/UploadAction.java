package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;

import pojo.UserPojo;
import utility.Pdf;
 
public class UploadAction extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1L;
 
    private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName; 
    private String action;
    @SuppressWarnings("rawtypes")
	private Map session;
    private InputStream fileStream;
       
    
	public InputStream getFileStream() {
		return fileStream;
	}
	public void setFileStream(InputStream fileStream) {
		this.fileStream = fileStream;
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
 
    public String execute()
    {
    	setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
    	if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
        return INPUT;        
    }
    public String upload()
    {
    	setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
        	try{
        		System.out.println("2");
                String filePath = "C:/Users/Public/Documents/";  // Path where uploaded file will be stored
                System.out.println("Server path:" + filePath); // check your path in console
                File fileToCreate = new File(filePath, "User"+"_"+userPojo.getUSER_ID()+"_Resume.doc");// Create file name  same as original
                FileUtils.copyFile(uploadFile, fileToCreate); // Just copy temp file content tos this file      
                return SUCCESS;
                }catch(Exception e)
                {
                    e.printStackTrace();
                    addActionError(e.getMessage());
                    return INPUT;         
                }	
        }
	public String download() throws Exception {
		
		setSession(ActionContext.getContext().getSession());
		UserPojo userPojo = (UserPojo) session.get("user");
		if (userPojo == null) {
			addActionError("Unauthorized access not allowed.");
			return ERROR;
		}
			try{
				setSession(ActionContext.getContext().getSession());								
				fileStream = new DataInputStream(
				  new FileInputStream("C:/Users/Public/Documents/" +"User"+"_"+userPojo.getUSER_ID()+"_Resume.doc" ));
			} catch (Exception ioEx) {
				ioEx.printStackTrace();
				addActionMessage("Resume is never uploaded, Please upload one than try this action.");
				return "fail";
			}			
		return "test-stream";
	}

    
}
