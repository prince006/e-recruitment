package utility;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates {
	private static SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
	public static Date getDate(String dateString) throws Exception {
		  String [] stemp=dateString.split("T");
		  String [] sd=stemp[0].split("-");
		  int year=Integer.parseInt(sd[0].trim());
		  int month=Integer.parseInt(sd[1].trim());
		  int date=Integer.parseInt(sd[2].trim());
		  Calendar cal=Calendar.getInstance();
		  cal.set(year,month-1,date);
		  System.out.println(month + " "+ date );
		  java.sql.Date sD=new java.sql.Date(cal.getTimeInMillis());
		  return sD;
		}
	public static String getFormatedDate(int min){
		java.util.Date date = new java.util.Date();
		long numberOfMSInMin = 1000*60;
		java.util.Date dateAftr = new java.util.Date(date.getTime() + numberOfMSInMin * min );		
		String rslt = df1.format(dateAftr);
		System.out.println(rslt);
		return rslt;
	}
	 
	public static void main(String[] args) {
		getFormatedDate(1);
	}
}
