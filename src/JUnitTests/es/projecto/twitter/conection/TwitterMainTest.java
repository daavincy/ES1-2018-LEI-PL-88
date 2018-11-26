package es.projecto.twitter.conection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import twitter4j.Status;

class TwitterMainTest {
	
	
	private String consumerKey = "WwkVm3nKOV5OF7b1iSkLqPE6w"; 
	private String consumerSecret = "DPKF4GyPbtgB3tO5RdnyOW2Ad03vq1V0fYZxorvTlakj8IjuAF"; 
	private String accessToken = "1052230420182519808-rDk4irssdofqNhmefXYpfjdwBicl3x"; 
	private String accessTokenSecret = "hXjYJYu2mGqh21IoxIDxZqupBAr8KW8abeLFBX8oU7MM9";
	
	TwitterMain t = new TwitterMain(consumerKey, consumerSecret, accessToken, accessTokenSecret);
			

	@Test
	void test() {
		ArrayList<Status> result = t.getStatuses();
		assertNotNull(result);
	}

}
