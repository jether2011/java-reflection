package com.jetherrodrigues.class4.attributes;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FieldValidators {
	public static Map<String, Object> getAttributesValues(Object object) throws IllegalArgumentException, IllegalAccessException{
		Map<String, Object> map = new HashMap<>();
		Class<?> clazz = object.getClass();
		
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(object));
		}
		
		return map;
	}
}
