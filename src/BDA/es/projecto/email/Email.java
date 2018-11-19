package es.projecto.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	private String user;
	private String pass;
	
	//Recive
	private String host; //pop3Host
	private String storeType;

	public Email(String user, String pass, String host, String storeType) {
		
		try {
			
			//create properties field
			Properties prop = new Properties();
			prop.put("mail.pop3.host", host);
			prop.put("mail.pop3.host", "995");
			prop.put("mail.pop3.starttls.enable", true);
			Session emailSession = Session.getDefaultInstance(prop);
		
			//create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");
			store.connect(host, user, pass);
			
		    //create the folder object and open it
			 Folder emailFolder = store.getFolder("INBOX");
		     emailFolder.open(Folder.READ_ONLY);
		     
		    //retrieve the messages from the folder in an array and print it
		      Message[] messages = emailFolder.getMessages();
		      System.out.println("messages.length---" + messages.length);

		      for (int i = 0, n = messages.length; i < n; i++) {
		         Message message = messages[i];
		         System.out.println("---------------------------------");
		         System.out.println("Email Number " + (i + 1));
		         System.out.println("Subject: " + message.getSubject());
		         System.out.println("From: " + message.getFrom()[0]);
		         System.out.println("Text: " + message.getContent().toString());
		      }
		      
		    //close the store and folder objects
		      emailFolder.close(false);
		      store.close();

		
		} catch (NoSuchProviderException e) {
	         e.printStackTrace();
	      } catch (MessagingException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	//Parametros da GUI
	public void sendMail(String from, String to, String subject, String text) {
		
		Properties props =System.getProperties();
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.strattls.required", "true");
		
		
		Session mailSession=Session.getDefaultInstance(props,null);
		try {
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
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void reciveMail() {
		
	}
	

}
