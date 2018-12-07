package es.projecto.email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.imap.IMAPFolder;

import es.projecto.config.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;


/**
 *
 * Class Email, Cria uma caixa de emails recebidos atraves dos dados do utilizador
 * e contem metodo de envio de emails.
 * @author afcma11
 *
 */
public class EmailClient {

	private IMAPFolder folder;
	private Session session;
	private Store store;
	private String username;
	private String password;

	/**
	* 
	*/
	public EmailClient() {
	}

	public void connect(String username, String password) throws MessagingException {
		this.username = username;
		this.password = password;
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		session = Session.getDefaultInstance(props);

		store = session.getStore("imaps");
		store.connect("imap.googlemail.com", username, password);
		folder = (IMAPFolder) store.getFolder("inbox");
		if (!folder.isOpen())
			folder.open(Folder.READ_ONLY);

	}
	/**
	 * Metodo devolve um arraylist de emails
	 * Cria uma caixa de emails recebidos atraves de host pop3
	 * 
	 * @return ArrayList de Email Recebidos
	 */
	public List<NewsHeaders> getEmailMessages(Properties filter) throws MessagingException {
		if (folder == null) {
			System.err.println("Client not connected...");
		}
		Message[] messages = folder.getMessages();
		ArrayList<NewsHeaders> output = new ArrayList<>();
		Arrays.stream(messages).forEach(message -> {
			Long id = 0L;
			int provider = Constants.EMAIL_ID;
			String shorttext;
			String text;
			String source;
			Date date;
			try {
				text = getTextFromMessage(message);
				shorttext = message.getSubject();
				source = message.getFrom()[0].toString();
				date = message.getSentDate();
				NewsHeaders msg = new NewsHeaders(id, provider, shorttext, text, source, date);
				output.add(msg);
			} catch (MessagingException | IOException e) {
			}
		});

		return output;
	}

	public void close() {
		if (store != null) {
			try {
				if (folder != null && folder.isOpen()) {
					folder.close(true);
				}

				store.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	private String getTextFromMessage(Message message) throws MessagingException, IOException {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
		String result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice in my tests
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				result = result + "\n" + html;
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
			}
		}
		return result;
	}
	
	/**
	 * Metodo que envia mail, atraves de um host SMTP
	 * 
	 * @param to      - Parametro ao qual sera enviado o mail
	 * @param subject - Parametro referente assunto/titulo do email
	 * @param text    - Parametro referente ao Texto do email
	 */
	public void sendMail(String to, String subject, String text) {

		
		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.strattls.required", "true");

		Session mailSession = Session.getDefaultInstance(props);
		try {
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(username));
			InternetAddress address = (new InternetAddress(to));
			msg.setRecipient(Message.RecipientType.TO, address);
			msg.setReplyTo(new Address[] {address});
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(text);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(username, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message sent");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
