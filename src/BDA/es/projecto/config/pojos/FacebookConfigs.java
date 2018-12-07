package es.projecto.config.pojos;

import java.io.Serializable;
import java.lang.reflect.Field;

public class FacebookConfigs extends AbstractConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2319191645228273695L;
	private String accessToken;
	private String clientId;
	private String appId;
	
	public FacebookConfigs(String accessToken, String clientId, String appId) {
		super();
		this.accessToken = accessToken;
		this.clientId = clientId;
		this.appId = appId;
	}

	public FacebookConfigs() {
		super();
		
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
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
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

	@Override
	public void setFieldValue(String propertyname, String propertyvalue) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		getClass().getDeclaredField(propertyname).set(this, propertyvalue);
		
	}
	
	
	
}
