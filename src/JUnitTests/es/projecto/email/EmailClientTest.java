package es.projecto.email;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;

import es.projecto.config.pojos.NewsHeaders;

public class EmailClientTest {
	private static final String PASSWORD = "!\"#$1234qwer";
	private static final String USER = "testelvino@gmail.com";

	
	@Test
	void testEmailConnection() throws MessagingException {
		EmailClient emailClient = new EmailClient();
		emailClient.connect(USER, PASSWORD);
	}
	
	@Test
	void testGetServerEmails() throws MessagingException {
		EmailClient emailClient = new EmailClient();
		emailClient.connect(USER, PASSWORD);
		List<NewsHeaders> result = emailClient.getEmailMessages(null);
		assertNotNull(result);
	}
	
	@Test
	void testSendAndReceiveEmail() throws MessagingException {
		EmailClient emailClient = new EmailClient();
		emailClient.connect(USER, PASSWORD);
		int result = emailClient.getEmailMessages(null).size();
		emailClient.sendMail(USER, "teste", "this is a test message");
		int result1  = emailClient.getEmailMessages(null).size();

		assertEquals(result+1, result1);
	}
}
