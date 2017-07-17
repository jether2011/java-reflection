package com.jetherrodrigues.class2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Executor {
	
	private static final Logger logger = LoggerFactory.getLogger(Executor.class);

	public static void main(String[] args) {
		DynamicLoading loader = new DynamicLoading();
		try {
			loader.loader("classes.properties");
			
			System.out.println(loader.getImplementation(List.class));
			System.out.println(loader.getImplementation(Map.class));
			
		} catch (ClassNotFoundException | IOException e) {
			logger.error(e.getMessage());
		}
	}

}