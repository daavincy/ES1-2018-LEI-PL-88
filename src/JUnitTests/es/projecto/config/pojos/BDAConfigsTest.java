package es.projecto.config.pojos;


import javax.swing.ImageIcon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.projecto.config.pojos.BDAConfigs;


public class BDAConfigsTest {

	@Test
	public void testGetLogoImage() throws Exception {

		ImageIcon testIcon = BDAConfigs.getLogoImage();
		Assertions.assertTrue(testIcon.getIconHeight()>0 && testIcon.getIconWidth()>0);	
	}
	
	
	
	@Test
	public void testGetLogoImageResized() throws Exception {
		int width = 120;
		int height = 120;
		ImageIcon testIcon = BDAConfigs.getLogoImage(120,120);
		Assertions.assertTrue(testIcon.getIconHeight()==height && testIcon.getIconWidth()==width);	
	}



	@Test
	public void testGetTwiterLogo() throws Exception {
		int width = 120;
		int height = 120;
		ImageIcon testIcon = BDAConfigs.getTwiterLogo(120,120);
		Assertions.assertTrue(testIcon.getIconHeight()==height && testIcon.getIconWidth()==width);	
	}
	
	@Test
	public void testGetMenuImageResized() throws Exception {
		int width = 120;
		int height = 120;
		ImageIcon testIcon = BDAConfigs.getMenuImage(120,120);
		Assertions.assertTrue(testIcon.getIconHeight()==height && testIcon.getIconWidth()==width);	
	}

}
