package com.jetherrodrigues.class4.attributes;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorClass4 {

	private static final Logger logger = LoggerFactory.getLogger(ExecutorClass4.class);
	
	public static void main(String[] args) {
		User user = new User();
		user.setName("Jether Rodrigues");
		user.setEmail("jether.rodrigues@test.com");
		user.setUsername("jether.rodrigues");
		user.setPassword("jether123");
		
		try {
			System.out.println(XMLGenerator.getXML(user));
			
			@SuppressWarnings("rawtypes")
			Map map = FieldValidators.getAttributesValues(user);
			
			for (Object key : map.keySet()) {
				logger.info("{} - {}", key.toString(), map.get(key));
			}
			
		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error(e.getMessage());
		}
		
	}

}
