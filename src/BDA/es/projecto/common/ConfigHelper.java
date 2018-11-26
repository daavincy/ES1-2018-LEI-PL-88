package es.projecto.common;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import es.projecto.hmi.pojos.Configurations;

public class ConfigHelper {
//	private static final Logger log = Log

	private ObjectMapper objectMapper;
	private static ConfigHelper instance;
	private final String CONFIG_FILE;

	public static ConfigHelper getInstance() {
		if (instance == null)
			instance = new ConfigHelper(null);
		return instance;
	}

	ConfigHelper(String filename) {
		if (filename == null)
			filename = "configs.xml";

		CONFIG_FILE = filename;
		objectMapper = new XmlMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	/**
	 * Metodo criado para salvar as configurações
	 * 
	 * @param configs representa o objecto {@link Configurations} que é usado para
	 *                passar as configurações para o ficheiro
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

			System.err.println(e);
		}
	}

	/**
	 * Metodo criado para obter as configurações
	 * @return configurations cache object
	 * @throws IOException se o ficheiro output não existir
	 */
	public Configurations getConfigurations() throws IOException {
		File output = new File(CONFIG_FILE);

		return objectMapper.readValue(output, Configurations.class);

	}
}
