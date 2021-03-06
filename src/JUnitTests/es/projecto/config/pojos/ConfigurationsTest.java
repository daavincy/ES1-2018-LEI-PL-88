package es.projecto.config.pojos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import es.projecto.config.ConfigHelper;
import es.projecto.config.pojos.Configurations;
import es.projecto.config.pojos.EmailConfigs;
import es.projecto.config.pojos.FacebookConfigs;
import es.projecto.config.pojos.TwitterConfigs;

public class ConfigurationsTest {

	@Test
	public void testGetfacebookConfigs() throws Exception {
		Configurations testelement = initializeConfigs();
		assertNotNull(testelement.getfacebookConfigs());
	}

	@Test
	public void testGettwitterConfigs() throws Exception {
		Configurations testelement = initializeConfigs();
		assertNotNull(testelement.gettwitterConfigs());
	}

	@Test
	public void testGetemailConfigs() throws Exception {
		Configurations testelement = initializeConfigs();
		assertNotNull(testelement.getemailConfigs());
	}

	@Test
	public void testSetfacebookConfigs() throws Exception {
		Configurations testelement = initializeConfigs();
		FacebookConfigs facebookConfigs = new FacebookConfigs("teste", "consumer", "value3");
		testelement.setfacebookConfigs(facebookConfigs);

		assertEquals(facebookConfigs, testelement.getfacebookConfigs());
	}

	@Test
	public void testSettwitterConfigs() throws Exception {
		Configurations testelement = initializeConfigs();
		TwitterConfigs twitterConfigs = new TwitterConfigs("teste", "consumer", "value3", "param4");
		testelement.settwitterConfigs(twitterConfigs);

		assertEquals(twitterConfigs, testelement.gettwitterConfigs());
	}

	@Test
	public void testSetemailConfigs() throws Exception {
		Configurations testelement = initializeConfigs();
		EmailConfigs emailConfigs = new EmailConfigs("teste", "passwordTeste");
		testelement.setemailConfigs(emailConfigs);

		assertEquals(emailConfigs, testelement.getemailConfigs());
		}

	private Configurations initializeConfigs() {
		ConfigHelper ch = ConfigHelper.getInstance();

			return ch.getConfigurations();
	
	}

}
