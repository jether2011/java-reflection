package com.jetherrodrigues.class3.objects;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorClass3 {
	
	private static final Logger logger = LoggerFactory.getLogger(ExecutorClass3.class);

	public static void main(String[] args) {
		DynamicLoading loader = new DynamicLoading();
		try {
			loader.loader("classes.properties");
			
			List<?> t = (List<?>) loader.getInstance(List.class);
			System.out.println(t.getClass());
			
			System.out.println(loader.getInstance2(List.class).getClass());
			
			Class3Interface obj = loader.getInstance3(Class3Interface.class, "Jether Rois");
			System.out.println(obj.getClass());
			
		} catch (ClassNotFoundException | IOException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			logger.error(e.getMessage());
		}
	}

}
