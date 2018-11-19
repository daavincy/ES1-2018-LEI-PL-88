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
import javax.mail.internet.NewsAddress;

public class Email {

	private String user;
	private String pass;

	// Recive
	//private String host; // pop3Host - para receber email
	private String storeType;
	private String host;

	public Email(String user, String pass, String host, String storeType) {
		this.user = user;
		this.pass = pass;
		this.host=host;
		this.storeType = storeType;
//		getEmails(user, pass, host);
	}
	
	/**
	 * 
	 * @param user
	 * @param pass
	 * @param host
	 */
	private void getEmails(String user, String pass, String host) {
		try {
			// create properties field
			Properties prop = new Properties();
			prop.put("mail.pop3.host", host);
			prop.put("mail.pop3.port", "995");
			prop.put("mail.pop3.starttls.enable", true);
			Session emailSession = Session.getDefaultInstance(prop);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");
			store.connect(host, user, pass);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
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

			// close the store and folder objects
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

	/**
	 * Metodo que envia mail, atravez de um host SMTP
	 * 
	 * @param to - Parametro ao qual será enviado o mail
	 * @param subject - paramentro referente assunto/titulo do email
	 * @param text - Parametro referente ao Texto do email
	 */
	public void sendMail(String from, String host, String to, String subject, String text) {

		//String from = user;

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.strattls.required", "true");

		Session mailSession = Session.getDefaultInstance(props, null);
		try {
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress address = (new InternetAddress(to));
			msg.setRecipient(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(text);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message sent");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {

		String host = "pop.gmail.com";// change accordingly
		String mailStoreType = "pop3";
		String username = "afcmota11@gmail.com";// change accordingly
		String password = "1234wasd";// change accordingly

		Email m = new Email(username, password, host, mailStoreType);
		m.sendMail("afcmota11@gmail.com", "smtp.gmail.com", "afcmota11@gmail.com", "Teste", "TESTE");

	}

}
