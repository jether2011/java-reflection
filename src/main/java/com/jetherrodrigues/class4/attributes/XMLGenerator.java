package com.jetherrodrigues.class4.attributes;

import java.lang.reflect.Field;

public class XMLGenerator {
	public static String getXML(Object object) throws IllegalArgumentException, IllegalAccessException{
		StringBuilder builder = new StringBuilder();
		
		Class<?> clazz = object.getClass();
		builder.append("<");
		builder.append(getLowerCaseName(clazz.getSimpleName()));
		builder.append("> \n");
		
		for (Field field : clazz.getDeclaredFields()) {
			// if the modifier of the filed is private you need use:
			field.setAccessible(true);
			
			builder.append("<");
			builder.append(getLowerCaseName(field.getName()));
			builder.append("> \n");
			
			builder.append(field.get(object));
			builder.append(" \n");
			
			builder.append("</");
			builder.append(getLowerCaseName(field.getName()));
			builder.append("> \n");
		}
		
		builder.append("</");
		builder.append(getLowerCaseName(clazz.getSimpleName()));
		builder.append("> \n");
		
		return builder.toString();	
	}
	
	private static String getLowerCaseName(String lower){
		return lower.toLowerCase();
	}
}
