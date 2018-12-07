package es.projecto.config.pojos;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "configurations")
public class Configurations implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6739376958016621627L;

	public Configurations() {
		super();
		// TODO Auto-generated constructor stub
	}

	FacebookConfigs facebookConfigs;
	TwitterConfigs twitterConfigs;
	EmailConfigs emailConfigs;
	
	/**
	 * Construtor para a cache de configurações que supostamente representam um ficheiro XML
	 * @param facebookConfigs as configurações que dizem respeito ao facebook
	 * @param twitterConfigs as configurações que dizem respeito ao twitter
	 * @param emailConfigs as configurações que dizem respeito ao email
	 */
	public Configurations(FacebookConfigs facebookConfigs, TwitterConfigs twitterConfigs, EmailConfigs emailConfigs) {
		super();
		this.facebookConfigs = facebookConfigs;
		this.twitterConfigs = twitterConfigs;
		this.emailConfigs = emailConfigs;
	}

	/**
	 * Este metodo obtem o objecto que persiste as configurações do facebook em utilização
	 * @return o objecto com as configurações
	 */
	public FacebookConfigs getfacebookConfigs() {
		return facebookConfigs;
	}

	/**
	 * Metodo que substitui as configurações guardadas em cache pelas novas configurações
	 * @param facebookConfigs contem as novas configurações
	 */
	public void setfacebookConfigs(FacebookConfigs facebookConfigs) {
		this.facebookConfigs = facebookConfigs;
	}

	/**
	 * Este metodo obtem o objecto que persiste as configurações do twitter em utilização
	 * @return o objecto com as configurações
	 */
	public TwitterConfigs gettwitterConfigs() {
		return twitterConfigs;
	}

	/**
	 * Metodo que substitui as configurações guardadas em cache pelas novas configurações
	 * @param twitterConfigs contem as novas configurações
	 */
	public void settwitterConfigs(TwitterConfigs twitterConfigs) {
		this.twitterConfigs = twitterConfigs;
	}

	/**
	 * Este metodo obtem o objecto que persiste as configurações do email em utilização
	 * @return o objecto com as configurações
	 */
	public EmailConfigs getemailConfigs() {
		return emailConfigs;
	}

	/**
	 * Metodo que substitui as configurações guardadas em cache pelas novas configurações
	 * @param emailConfigs contem as novas configurações
	 */
	public void setemailConfigs(EmailConfigs emailConfigs) {
		this.emailConfigs = emailConfigs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
	if(!(obj instanceof Configurations)) return false;
	Configurations input = (Configurations) obj;
	return input.emailConfigs.getUser().equals(this.getemailConfigs().getUser()) &&
			input.twitterConfigs.getAccessToken().equals(this.gettwitterConfigs().getAccessToken());
	}


	
	

	
	
	

}
