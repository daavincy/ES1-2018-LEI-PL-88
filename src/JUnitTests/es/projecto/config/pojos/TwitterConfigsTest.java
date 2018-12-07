package es.projecto.config.pojos;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwitterConfigsTest {


	@Test
	public void testTwitterConfigConstructors() throws Exception {
		TwitterConfigs cfg = new TwitterConfigs();
		String consumerKey = "consumerKey";
		String consumerSecret = "consumerSecret";
		String accessToken = "accessToken";
		String accessTokenSecret = "accessTokenSecret";
		cfg = new TwitterConfigs(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		Assertions.assertEquals(accessToken, cfg.getAccessToken());
		Assertions.assertEquals(accessTokenSecret, cfg.getAccessTokenSecret());
		Assertions.assertEquals(consumerKey, cfg.getConsumerKey());
		Assertions.assertEquals(consumerSecret, cfg.getConsumerSecret());
		
	}
	
	@Test
	public void testSetTwitterConfig() throws Exception {
		String consumerKey = "consumerKey";
		String consumerSecret = "consumerSecret";
		String accessToken = "accessToken";
		String accessTokenSecret = "accessTokenSecret";
		String newconsumerKey = "newconsumerKey";
		String newconsumerSecret = "newconsumerSecret";
		String newaccessToken = "newaccessToken";
		String newaccessTokenSecret = "newaccessTokenSecret";
		TwitterConfigs cfg = new TwitterConfigs(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		cfg.setAccessToken(newaccessToken);
		cfg.setAccessTokenSecret(newaccessTokenSecret);
		cfg.setConsumerKey(newconsumerKey);
		cfg.setConsumerSecret(newconsumerSecret);
		
		Assertions.assertEquals(newaccessToken, cfg.getAccessToken());
		Assertions.assertEquals(newaccessTokenSecret, cfg.getAccessTokenSecret());
		Assertions.assertEquals(newconsumerKey, cfg.getConsumerKey());
		Assertions.assertEquals(newconsumerSecret, cfg.getConsumerSecret());
		
		Assertions.assertNotEquals(accessToken, cfg.getAccessToken());
		Assertions.assertNotEquals(accessTokenSecret, cfg.getAccessTokenSecret());
		Assertions.assertNotEquals(consumerKey, cfg.getConsumerKey());
		Assertions.assertNotEquals(consumerSecret, cfg.getConsumerSecret());
		
	}

	@Test
	public void testGetFieldValue() throws Exception {
		String consumerKey = "consumerKey";
		String consumerSecret = "consumerSecret";
		String accessToken = "accessToken";
		String accessTokenSecret = "accessTokenSecret";
		TwitterConfigs cfg = new TwitterConfigs(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		
		assertNotNull(cfg.getFields());
		
		assertNotNull(cfg.getFieldValue("consumerKey"));
		
		Assertions.assertEquals("",cfg.getFieldValue("bananas"));
		
	}

	@Test
	public void testSetFieldValue() throws Exception {
		String consumerKey = "consumerKey";
		String consumerSecret = "consumerSecret";
		String accessToken = "accessToken";
		String accessTokenSecret = "accessTokenSecret";
		TwitterConfigs cfg = new TwitterConfigs(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		cfg.setFieldValue(consumerSecret, "bananas");
		Assertions.assertEquals("bananas", cfg.getConsumerSecret());
	}

}
