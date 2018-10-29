package es.projecto.email;

import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;

import java.util.*;


public class SendMail {
	
	public static void main(String[] args) {
		try {
			String host= "smtp.gmail.com";
			String user= "jpfabc@gmail.com";
			String pass= "jpfabc123";
			String to= "jpfabc@live.com.pt";
			String from= "jpfabc@gmail.com";
			String subject= "test";
			String text= "test received";
			
			Properties props =System.getProperties();
			
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.strattls.required", "true");
			
			
			Session mailSession=Session.getDefaultInstance(props,null);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress address= (new InternetAddress(to));
			msg.setRecipient(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(text);
			
			Transport transport=mailSession.getTransport("smtp");
			transport.connect(host,user,pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message sent");
		}catch(Exception ex)
		{
			System.out.println(ex);
			
		}
	}
		
	
} 