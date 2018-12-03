package es.projecto.hmi.pojos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BDAConfigs {
	public static String twitter_consumerKey = "WwkVm3nKOV5OF7b1iSkLqPE6w";
	public static String twitter_consumerSecret = "DPKF4GyPbtgB3tO5RdnyOW2Ad03vq1V0fYZxorvTlakj8IjuAF";
	public static String twitter_accessToken = "1052230420182519808-rDk4irssdofqNhmefXYpfjdwBicl3x";
	public static String twitter_accessTokenSecret = "hXjYJYu2mGqh21IoxIDxZqupBAr8KW8abeLFBX8oU7MM9";

	static ImageIcon getLogoImage() {
		return new ImageIcon(BDAConfigs.class.getClassLoader().getResource("logo_iscte.png"));
	}

	static ImageIcon getMenuImage() {
		return new ImageIcon(BDAConfigs.class.getClassLoader().getResource("menu.png"));
	}
	
	static ImageIcon getTwitterImage() {
		return new ImageIcon(BDAConfigs.class.getClassLoader().getResource("twitter.png"));
	}
	
	static ImageIcon getFacebookImage() {
		return new ImageIcon(BDAConfigs.class.getClassLoader().getResource("facebook.png"));
	}
	
	static ImageIcon getEmailImage() {
		return new ImageIcon(BDAConfigs.class.getClassLoader().getResource("email.png"));
	}

	private static ImageIcon resizeImage(ImageIcon input, int width, int height) {
		Image image = input.getImage(); // transform it
		Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		return new ImageIcon(newimg);
	}

	public static ImageIcon getLogoImage(int width, int height)  {
		ImageIcon imageIcon = getLogoImage(); // load the image to a imageIcon
		return resizeImage(imageIcon, width, height);
	}

	public static ImageIcon getMenuImage(int width, int height) {
		ImageIcon imageIcon = getMenuImage(); // load the image to a imageIcon
		return resizeImage(imageIcon, width, height);
	}

	public static ImageIcon getTwiterLogo(int width, int height) {
		return resizeImage(getTwitterImage(), width, height);
	}
	
	public static ImageIcon getFacebookImage(int width, int height) {
		return resizeImage(getFacebookImage(), width, height);
	}
	
	public static ImageIcon getEmailImage(int width, int height) {
		return resizeImage(getEmailImage(), width, height);
	}

}
