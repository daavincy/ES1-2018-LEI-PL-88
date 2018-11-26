package es.projecto.hmi.pojos;

public class FacebookConfigs {

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
	
	
	
}
