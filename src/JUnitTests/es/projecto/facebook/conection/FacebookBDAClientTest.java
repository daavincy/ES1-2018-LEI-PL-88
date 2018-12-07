package es.projecto.facebook.conection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import es.projecto.config.pojos.NewsHeaders;

class FacebookBDAClientTest {
	
	private String accessToken ="EAAElkZB1PPCABAJqd07ZAZB1gRA6zpJBnBXAvaTFw5qoa4zkdRK7m2SsApCVWhFvLdK4Y14jQcXGuCoJnizGDUCvDJHPzxfQXD0n7FVqdALG6K3XdPiow83TVJ1zb618TgLl78w34lC3Euuz7ZBuNfZCsDIFXOjujXzw6LySLLaHZAZC3REKQwL";

	FacebookBDAClient fb = new FacebookBDAClient(accessToken);

	@Test
	void test() {
		FacebookBDAClient fb = new FacebookBDAClient(accessToken);
		ArrayList<NewsHeaders> result = fb.getUserTimelinePosts();
		assertNotNull(result);
	}

}
