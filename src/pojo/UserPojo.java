package pojo;

import java.sql.Timestamp;
import java.util.Set;

public class UserPojo 
{
	private Integer USER_ID;//	NUMBER
	private String CATEGORY;//	VARCHAR
	private String NAME;//	VARCHAR
	private String ADDRESS;//	VARCHAR
	private String CITY;//	VARCHAR
	private String STATE;//	VARCHAR
	private String EMAIL;//	VARCHAR
	private String PASSWORD;//	VARCHAR
	private String MOBILE;//	VARCHAR
	private String IS_ACTIVE;//	VARCHAR
	private String CREATED_BY;//	VARCHAR
	private Timestamp CREATED_ON;//	TIMESTAMP
	private Set<Job> JOBS;
	private Set<Resume> saved_resume;
	private Set<Resume> purchased_resume;

	
	
	public Set<Resume> getSaved_resume() {
		return saved_resume;
	}

	public void setSaved_resume(Set<Resume> saved_resume) {
		this.saved_resume = saved_resume;
	}

	public Set<Resume> getPurchased_resume() {
		return purchased_resume;
	}

	public void setPurchased_resume(Set<Resume> purchased_resume) {
		this.purchased_resume = purchased_resume;
	}

	public Set<Job> getJOBS() {
		return JOBS;
	}

	public void setJOBS(Set<Job> jOBS) {
		JOBS = jOBS;
	}

	public UserPojo() {
		CREATED_ON=new Timestamp(System.currentTimeMillis());
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

}
