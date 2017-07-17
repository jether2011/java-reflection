package com.jetherrodrigues.class3;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Executor {
	
	private static final Logger logger = LoggerFactory.getLogger(Executor.class);

	public static void main(String[] args) {
		DynamicLoading loader = new DynamicLoading();
		try {
			loader.loader("classes.properties");
			
			List<?> t = null;
			try {
				t = (List<?>) loader.getInstance(List.class);
			} catch (InstantiationException | IllegalAccessException e) {
				logger.error(e.getMessage());
			}
			
			System.out.println(t.getClass());
			
		} catch (ClassNotFoundException | IOException e) {
			logger.error(e.getMessage());
		}
	}

}
