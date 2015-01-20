package dao;

import pojo.Job;
import pojo.UserPojo;
//import COM.ibm.db2.jdbc.app.DB2Driver;
import com.ibm.db2.jcc.DB2BaseDataSource;
public class Test {

	
	public static void main(String[] args) {
		UserPojo userPojo = new UserPojo();
		userPojo.setADDRESS("c-252, Yamuna Enclave");
		userPojo.setCITY("Panipat");
		userPojo.setCREATED_BY("Amit Aryan");
		userPojo.setCATEGORY("A");
		userPojo.setEMAIL("admin@gmail.com");
		userPojo.setPASSWORD("admin");
		userPojo.setIS_ACTIVE("Y");
		userPojo.setMOBILE("9354634153");
		userPojo.setNAME("AMIT ARYAN");
		userPojo.setSTATE("Haryana");
		new UserDAO().insert(userPojo);			
		System.out.println("Done...");
		System.out.println(userPojo.getCREATED_ON());
	}
}
