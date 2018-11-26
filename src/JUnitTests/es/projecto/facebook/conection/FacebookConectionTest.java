package es.projecto.facebook.conection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.restfb.types.Post;

import es.projecto.hmi.pojos.NewsHeaders;

class FacebookConectionTest {
	
	private String accessToken ="EAAElkZB1PPCABAJqd07ZAZB1gRA6zpJBnBXAvaTFw5qoa4zkdRK7m2SsApCVWhFvLdK4Y14jQcXGuCoJnizGDUCvDJHPzxfQXD0n7FVqdALG6K3XdPiow83TVJ1zb618TgLl78w34lC3Euuz7ZBuNfZCsDIFXOjujXzw6LySLLaHZAZC3REKQwL";

	FacebookConection fb = new FacebookConection(accessToken);

	@Test
	void test() {
		ArrayList<NewsHeaders> result = fb.getUserTimelinePosts();
		assertNotNull(result);
	}

}
