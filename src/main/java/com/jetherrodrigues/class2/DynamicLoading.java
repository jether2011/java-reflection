package com.jetherrodrigues.class2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DynamicLoading {
	
	private Map<Class<?>, Class<?>> map = new HashMap<>();
	
	public void loader(String file) throws FileNotFoundException, IOException, ClassNotFoundException{
		Properties properties = new Properties();
		properties.load(getClass().getClassLoader().getResourceAsStream(file));
		for (Object key : properties.keySet()) {
			Class<?> interfaces = Class.forName(key.toString());
			Class<?> implementation = Class.forName(properties.get(key).toString());
			
			if (!interfaces.isInterface()) {
				throw new RuntimeException("The hipotetic interface " + interfaces.getName() + " is not really one interface.");
			}
			
			if (!interfaces.isAssignableFrom(implementation)) {
				throw new RuntimeException("The class " + implementation.getName() + " doesn´t implement the interface " + interfaces.getName());
			}
			map.put(interfaces, implementation);
		}
	}
	
	public Class<?> getImplementation(Class<?> interfaces) {
		return map.get(interfaces);
	}
}
