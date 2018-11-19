package es.projecto.common;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import es.projecto.hmi.pojos.Configurations;
import es.projecto.hmi.pojos.EmailConfigs;
import es.projecto.hmi.pojos.FacebookConfigs;
import es.projecto.hmi.pojos.TwitterConfigs;


public class ProtoConfigHelper {
//	private static final Logger log = Log

	private ObjectMapper objectMapper;
	private static ProtoConfigHelper instance;
	private final String CONFIG_FILE;

	public static ProtoConfigHelper getInstance() {
		if (instance == null)
			instance = new ProtoConfigHelper(null);
		return instance;
	}

	ProtoConfigHelper(String filename) {
		if(filename==null)
			filename ="configs.xml";
		
		CONFIG_FILE=filename;
		objectMapper = new XmlMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	/**
	 * Metodo criado para salvar as configurações
	 * 
	 * @param configs representa o objecto {@link Configurations} que é usado para passar as configurações para o ficheiro
	 */
	public void saveConfigurations(Configurations configs) {

		File output = new File(CONFIG_FILE);
		try {
			if (output.exists()) {
				objectMapper.writeValue(output, configs);
			} else {
				output.createNewFile();
				objectMapper.writeValue(output, configs);
			}
		} catch (IOException e) {
			
		}
	}
	
	public Configurations getConfigurations() throws IOException {
		File output = new File(CONFIG_FILE);
		if(output.exists()) {
			return objectMapper.readValue(output, Configurations.class);
		}
		
		return null;
	}

	public static void main(String[] args) {
		ProtoConfigHelper.getInstance()
				.saveConfigurations(new Configurations(new FacebookConfigs("access_token", "client_id", "app_id"),
						new TwitterConfigs("consumer_key", "consumer_secret", "access_token", "access_token_secret"),
						new EmailConfigs("user", "password")));
	}
}
