package es.projecto.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import es.projecto.hmi.pojos.Configurations;
import es.projecto.hmi.pojos.EmailConfigs;
import es.projecto.hmi.pojos.FacebookConfigs;
import es.projecto.hmi.pojos.TwitterConfigs;

public class ConfigHelperTest {

	private String filename;

	@Test
	public void testGetInstance() throws Exception {
		assertNotNull(ConfigHelper.getInstance());
	}

	@Test
	public void testSaveConfigurations() throws Exception {

		ConfigHelper ch = createTestResources();

		Configurations configs = getTestConfigs();

		ch.saveConfigurations(configs);

		assertNotNull(ch.getConfigurations());
		removeTestResources();
	}

	private Configurations getTestConfigs() {
		return new Configurations(new FacebookConfigs("access_token", "client_id", "app_id"),
				new TwitterConfigs("consumer_key", "consumer_secret", "access_token", "access_token_secret"),
				new EmailConfigs("user", "password"));
	}
	
	@Test
	public void testGetConfigurations() throws Exception {
		ConfigHelper ch = createTestResources();
		Configurations configs = getTestConfigs();
		ch.saveConfigurations(configs);
		assertEquals(ch.getConfigurations(), configs);
		
	}

	private ConfigHelper createTestResources() {
		filename = "testConfig.xml";
		ConfigHelper ch = new ConfigHelper(filename);
		return ch;
	}

	private void removeTestResources() {
		File io = new File(filename);
		io.delete();
	}



}
