package es.projecto.email;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import es.projecto.hmi.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;

/**
 * Class Email, Cria uma caixa de emails recebidos atravezz dos dados do utilizador
 * e comtem metodo de envio de emails.
 * @author afcma11
 *
 */
public class Email {

	private String user;
	private String pass;

	private String storeType;
	
	private String hostRecive;
	private String hostSend;
	
	/**
	 * Construtor da classe EMAIL.
	 * Com os dados de utilizador (parametros)
	 * Assume automaticamente os hosts para conectar ao servidor
	 * 
	 * @param user - parametro do tipo String, email de utilizador
	 * @param pass - parametro do tipo String, password do utilizador
	 */
	public Email(String user, String pass) {
		this.user = user;
		this.pass = pass;

		hostSend = "smtp.gmail.com";
		hostRecive = "pop.gmail.com";
		
		storeType = "pop3";
		
		//getEmails(user, pass, host);
	}

	/**
	 * Metodo devolve um arraylist de emails
	 * Cria uma caixa de emails recebidos atravez de host pop3
	 * 
	 * @return ArrayList de Email Recebidos
	 */
	private List<NewsHeaders> getEmails() {
		try {
			// create properties field
			Properties prop = new Properties();
			prop.put("mail.pop3.host", hostRecive);
			prop.put("mail.pop3.port", "995");
			prop.put("mail.pop3.starttls.enable", true);
			Session emailSession = Session.getDefaultInstance(prop);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");
			store.connect(hostRecive, user, pass);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);
			
			List<NewsHeaders> a = new ArrayList<>();
			
			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				
				a.add(new NewsHeaders(null, Constants.EMAIL_ID, message.getSubject(), message.getContent().toString() , message.getFrom()[0].toString(), message.getReceivedDate()));
						
			}
			// close the store and folder objects
			emailFolder.close(false);
			store.close();
			
			return a;


		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * Metodo que envia mail, atravez de um host SMTP
	 * 
	 * @param to      - Parametro ao qual sera enviado o mail
	 * @param subject - paramentro referente assunto/titulo do email
	 * @param text    - Parametro referente ao Texto do email
	 */
	public void sendMail(String from, String to, String subject, String text) {

		// String from = user;

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", hostSend);
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
			transport.connect(hostSend, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message sent");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public static void main(String[] args) {

		String username = "afcmota11@gmail.com";
		String password = "1234wasd";

		Email m = new Email(username, password);
		m.sendMail("afcmota11@gmail.com", "afcmota11@gmail.com", "Teste", "TESTE");
		m.getEmails();

	}

}
