package es.projecto.hmi.pojos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "configurations")
public class Configurations {
	FacebookConfigs facebookConfigs;
	TwitterConfigs twitterConfigs;
	EmailConfigs emailConfigs;
	
	public Configurations(FacebookConfigs facebookConfigs, TwitterConfigs twitterConfigs, EmailConfigs emailConfigs) {
		super();
		this.facebookConfigs = facebookConfigs;
		this.twitterConfigs = twitterConfigs;
		this.emailConfigs = emailConfigs;
	}

	/**
	 * @return the facebookConfigs
	 */
	public FacebookConfigs getfacebookConfigs() {
		return facebookConfigs;
	}

	/**
	 * @param facebookConfigs the facebookConfigs to set
	 */
	public void setfacebookConfigs(FacebookConfigs facebookConfigs) {
		this.facebookConfigs = facebookConfigs;
	}

	/**
	 * @return the twitterConfigs
	 */
	public TwitterConfigs gettwitterConfigs() {
		return twitterConfigs;
	}

	/**
	 * @param twitterConfigs the twitterConfigs to set
	 */
	public void settwitterConfigs(TwitterConfigs twitterConfigs) {
		this.twitterConfigs = twitterConfigs;
	}

	/**
	 * @return the emailConfigs
	 */
	public EmailConfigs getemailConfigs() {
		return emailConfigs;
	}

	/**
	 * @param emailConfigs the emailConfigs to set
	 */
	public void setemailConfigs(EmailConfigs emailConfigs) {
		this.emailConfigs = emailConfigs;
	}


	
	

	
	
	

}
