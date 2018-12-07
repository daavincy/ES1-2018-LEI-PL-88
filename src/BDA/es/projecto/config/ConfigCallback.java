package es.projecto.config;

public interface ConfigCallback {
	void updateConfigValue(String propertyname, String propertyvalue);
	void removeConfigValue(String string, String text);

}
