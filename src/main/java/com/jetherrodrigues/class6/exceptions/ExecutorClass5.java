package com.jetherrodrigues.class6.exceptions;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorClass5 {

	private static final Logger logger = LoggerFactory.getLogger(ExecutorClass5.class);
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User user = new User();
		user.setName("Jether Rodrigues");
		user.setEmail("jether.rodrigues@test.com");
		user.setUsername("jether.rodrigues");
		user.setPassword("jether123");
		
		if(Validator.isValidMethod(user)){
			logger.info("{} is valid.", user.getClass().getName());
		} else {
			logger.info("{} is not valid.", user.getClass().getName());
		}
		
	}

}
