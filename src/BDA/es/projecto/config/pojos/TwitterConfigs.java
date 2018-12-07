package es.projecto.config.pojos;

import java.io.Serializable;
import java.lang.reflect.Field;

public class TwitterConfigs extends AbstractConfig implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TwitterConfigs() {
		super();
	}

	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessTokenSecret;
	
	public TwitterConfigs(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.accessToken = accessToken;
		this.accessTokenSecret = accessTokenSecret;
	}

	/**
	 * @return the consumerKey
	 */
	public String getConsumerKey() {
		return consumerKey;
	}

	/**
	 * @param consumerKey the consumerKey to set
	 */
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	/**
	 * @return the consumerSecret
	 */
	public String getConsumerSecret() {
		return consumerSecret;
	}

	/**
	 * @param consumerSecret the consumerSecret to set
	 */
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the accessTokenSecret
	 */
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	/**
	 * @param accessTokenSecret the accessTokenSecret to set
	 */
	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}


	@Override
	protected Field[] getFields() {

		return getClass().getDeclaredFields();
	}

	@Override
	protected String getFieldValue(String name) {
		// TODO Auto-generated method stub
		try {
			return (String) getClass().getDeclaredField(name).get(this);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			return "";
		}
	}

	public void setFieldValue(String propertyname, String propertyvalue) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		getClass().getDeclaredField(propertyname).set(this, propertyvalue);
		
	}
	
}
