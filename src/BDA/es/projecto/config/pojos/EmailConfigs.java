package es.projecto.config.pojos;

import java.io.Serializable;
import java.lang.reflect.Field;

public class EmailConfigs extends AbstractConfig implements Serializable{
	public EmailConfigs() {
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 6194755115417996443L;
	private String user;
	private String password;
	public EmailConfigs(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
