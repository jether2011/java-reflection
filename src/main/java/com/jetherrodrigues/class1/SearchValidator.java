package com.jetherrodrigues.class1;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author JETHER ROIS
 *
 */
public class SearchValidator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6988068844594598922L;

	public static List<String> getAttributesIfContains(Object o, String search) throws IllegalArgumentException, IllegalAccessException {
		List<String> list = new ArrayList<>();

		Class<?> clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getName().toString().contains(search)) {
				list.add(field.getName());
			}
		}

		return list;
	}
	
	public static List<String> getAllAttributesSearch(Object o, String search) throws IllegalArgumentException, IllegalAccessException {
		List<String> list = new ArrayList<>();

		Class<?> clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(o);
			if (value != null) {
				if (value.toString().contains(search)) {
					list.add(field.getName());
				}
			}
		}

		return list;
	}
	
	
}
