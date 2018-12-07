package es.projecto.hmi.visualeelements;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.projecto.config.ConfigCallback;

public class ConfigPanelTest {

	@Test
	public void testConfigPanel() throws Exception {
		ArrayList<String[]> list = new ArrayList<>();
		String value = "bananas";
		String key = "teste";
		list.add(new String[] { key, value });
		ConfigPanel cp = new ConfigPanel(list, new ConfigCallback() {

			@Override
			public void updateConfigValue(String propertyname, String propertyvalue) {
				Assertions.assertEquals(key, propertyname);
				Assertions.assertEquals(value, propertyvalue);
			}

			@Override
			public void removeConfigValue(String string, String text) {
				Assertions.assertEquals(key, string);
				Assertions.assertEquals("", text);

			}
		});
		;
		Assertions.assertEquals(key, ((JLabel) cp.getComponents()[0]).getText());
		Assertions.assertEquals(value, ((JTextField) cp.getComponents()[1]).getText());
		((JTextField) cp.getComponents()[1]).setText(value);

	}

	@Test
	public void testCalcRowSpecs() throws Exception {
		ConfigPanel cp = new ConfigPanel(null, null);
		int size = 4;
		Assertions.assertEquals((size * 2) + 2, cp.calcRowSpecs(size).length);
	}

}
