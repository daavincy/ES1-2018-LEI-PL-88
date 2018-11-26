package es.projecto.email;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import es.projecto.hmi.pojos.NewsHeaders;

class EmailTest {
	private static final String PASSWORD = "1234wasd";
	private static final String USER = "afcmota11@gmail.com";

	

	@Test
	void getServerEmails() {
		Email emailClient = new Email(USER, PASSWORD);
		List<NewsHeaders> result = emailClient.getEmails();
		assertNotNull(result);
	}
	
	@Test
	void testSendAndReceiveEmail() {
		Email emailClient = new Email(USER, PASSWORD);
		String text = "testeMessage";
		int emails = emailClient.getEmails().size(); 
		emailClient.sendMail(USER, USER, "teste", text);
		int result = emailClient.getEmails().size();

		assertEquals(emails, result);
	}
}
