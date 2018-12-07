package es.projecto.hmi.visualeelements;

import static org.junit.Assert.assertNotNull;

import javax.swing.JTabbedPane;

import org.junit.jupiter.api.Test;

import es.projecto.config.pojos.Configurations;
import es.projecto.config.pojos.EmailConfigs;
import es.projecto.config.pojos.FacebookConfigs;
import es.projecto.config.pojos.TwitterConfigs;

public class ConfigurationsDialogTest {

	@Test
	public void testGetTabbedPane() throws Exception {
		ConfigurationsDialog cd = new ConfigurationsDialog();
		JTabbedPane res = cd.getTabbedPane(new Configurations(new FacebookConfigs(), new TwitterConfigs(), new EmailConfigs()));
		assertNotNull(res);
	}

}
