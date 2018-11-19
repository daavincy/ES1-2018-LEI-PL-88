package es.projecto.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import es.projecto.hmi.pojos.Configurations;
import es.projecto.hmi.pojos.EmailConfigs;
import es.projecto.hmi.pojos.FacebookConfigs;
import es.projecto.hmi.pojos.TwitterConfigs;

public class ProtoConfigHelper {

	private ObjectMapper objectMapper;
	private static ProtoConfigHelper instance;
	
	public static ProtoConfigHelper getInstance() {
		if(instance==null)
			instance=new ProtoConfigHelper();
		return instance;
	}

	public ProtoConfigHelper() {
		objectMapper = new XmlMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	void saveConfigurations() {
		Configurations teste = new Configurations(new FacebookConfigs("access_token", "client_id", "app_id"),new TwitterConfigs("consumer_key", "consumer_secret", "access_token", "access_token_secret"), new EmailConfigs("user", "password"));
		String xml="";
		try {
			xml = objectMapper.writeValueAsString(teste);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File output = new File("configs.xml");
		try {
			output.createNewFile();
			System.out.println(output.getAbsolutePath());
		} catch (IOException e) {
		} 
		FileOutputStream oFile = null;
		try {
			 oFile = new FileOutputStream(output, false);
		} catch (FileNotFoundException e) {
		} 
		try {
			oFile.write(xml.getBytes("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(xml);
	}
	
	
public static void main(String[] args) {
	ProtoConfigHelper.getInstance().saveConfigurations();
}
}
