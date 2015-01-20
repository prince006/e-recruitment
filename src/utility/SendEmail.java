package utility;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import dao.*;
import action.*;

public class SendEmail
{
	public static void main(String[] args) 
	{
		//Integer passcode = new SendEmail().send("amitachala@gmail.com");
		//System.out.println("passcode--->"+passcode);
	}
	
	public void send(String receiver, String mobile)
	{
	  
	   mobile="91"+mobile;
	   final String username = "ers.amit2013@gmail.com";
	   final String password = "Amit_Aryan5390";

	   Properties props = new Properties();
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.port", "587");

	   Session session = Session.getInstance(props,new javax.mail.Authenticator() 
	   {
		   protected PasswordAuthentication getPasswordAuthentication() 
		   {
			   return new PasswordAuthentication(username, password);
		   }
	   });

	   try 
	   {
		   Message message = new MimeMessage(session);
		   message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiver));
		   message.setSubject("no-reply@ers.com");
		   message.setContent("<h1>Welcome to E Recruitment SYstem<h1><hr/><br/>" +
		   		"To activate the account Please Click the link given below<br/>" +
		   		"On clicking you will get a password on your registered Mobile <br/>" +
		   		"You have to change your password using the given password in the mobile" +
		   		"<a href=http://localhost:8081/ERS/UserAuthentication.action?EMAIL="+receiver+"&MOBILE="+mobile+"&action=UserAuthentication>" +
		   		"Activate Your Account by clicking Here</a>","text/html");
		   
		   Transport.send(message);

	   } 
	   catch (MessagingException e) 
	   {
		  
		   throw new RuntimeException(e);
	   }
	   
	   System.out.println("Activation mail send to "+receiver);
	   
	  
   }
}