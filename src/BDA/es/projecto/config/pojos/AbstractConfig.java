package es.projecto.config.pojos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class AbstractConfig {

	
	/**
	 * Obtem os campos e o valor de cada propriedade
	 * @return
	 */
	@JsonIgnore
	public List<String[]> getValuesAsList(){
		Field[] fields = getFields();
		ArrayList<String[]> output = new ArrayList<String[]>();
		Arrays.stream(fields).filter(t->!t.getName().equals("serialVersionUID")).forEach(field->{
			output.add(new String[] {field.getName(),getFieldValue(field.getName())});
		});
		return output;
		
	}

	protected abstract Field[] getFields();
	protected abstract String getFieldValue(String name);

	public abstract void setFieldValue(String propertyname, String propertyvalue)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
		
	
}
