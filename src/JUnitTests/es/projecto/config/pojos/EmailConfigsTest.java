package es.projecto.config.pojos;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailConfigsTest {

		String username = "username";
		String password= "consumerKey";
		String appId = "consumerSecret";
		String newusername = "newconsumerKey";
		String newpassword = "newconsumerSecret";
		String newappId = "newusername";
		EmailConfigs cfg ;

		void init() {

			cfg = new EmailConfigs(username, password);
		}

		@Test
		public void testEmailConfigs() throws Exception {
			cfg = new EmailConfigs();
			init();
			Assertions.assertEquals(username, cfg.getUser());
			Assertions.assertEquals(password, cfg.getPassword());
		}

		@Test
		public void testSetEmailConfig() throws Exception {
			init();
			cfg.setUser(newusername);
			cfg.setPassword(newpassword);

			Assertions.assertEquals(newusername, cfg.getUser());
			Assertions.assertEquals(newpassword, cfg.getPassword());

			Assertions.assertNotEquals(username, cfg.getUser());
			Assertions.assertNotEquals(password, cfg.getPassword());

		}

		@Test
		public void testGetFieldValue() throws Exception {
			init();

			assertNotNull(cfg.getFields());

			assertNotNull(cfg.getFieldValue("username"));

			Assertions.assertEquals("", cfg.getFieldValue("bananas"));

		}

		@Test
		public void testSetFieldValue() throws Exception {
			init();
			cfg.setFieldValue("user", "bananas");
			Assertions.assertEquals("bananas", cfg.getUser());
		}

}
