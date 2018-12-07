package es.projecto.config.pojos;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FacebookConfigsTest {
	String accessToken = "accessToken";
	String clientId= "consumerKey";
	String appId = "consumerSecret";
	String newaccessToken = "newconsumerKey";
	String newclientId = "newconsumerSecret";
	String newappId = "newaccessToken";
	FacebookConfigs cfg = new FacebookConfigs();

	void init() {

		cfg = new FacebookConfigs(accessToken, clientId, appId);
	}

	@Test
	public void testFacebookConfigs() throws Exception {
		cfg = new FacebookConfigs();
		init();
		Assertions.assertEquals(accessToken, cfg.getAccessToken());
		Assertions.assertEquals(clientId, cfg.getClientId());
		Assertions.assertEquals(appId, cfg.getAppId());
	}

	@Test
	public void testSetFacebookConfig() throws Exception {
		init();
		cfg.setAccessToken(newaccessToken);
		cfg.setClientId(newclientId);
		cfg.setAppId(newappId);

		Assertions.assertEquals(newaccessToken, cfg.getAccessToken());
		Assertions.assertEquals(newclientId, cfg.getClientId());
		Assertions.assertEquals(newappId, cfg.getAppId());

		Assertions.assertNotEquals(accessToken, cfg.getAccessToken());
		Assertions.assertNotEquals(clientId, cfg.getClientId());
		Assertions.assertNotEquals(appId, cfg.getAppId());

	}

	@Test
	public void testGetFieldValue() throws Exception {
		init();

		assertNotNull(cfg.getFields());

		assertNotNull(cfg.getFieldValue("accessToken"));

		Assertions.assertEquals("", cfg.getFieldValue("bananas"));

	}

	@Test
	public void testSetFieldValue() throws Exception {
		init();
		cfg.setFieldValue("accessToken", "bananas");
		Assertions.assertEquals("bananas", cfg.getAccessToken());
	}

}
