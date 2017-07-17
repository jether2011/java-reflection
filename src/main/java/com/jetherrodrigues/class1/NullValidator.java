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
public class NullValidator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6988068844594598922L;

	public static List<String> getAllNullAttributes(Object o) throws IllegalArgumentException, IllegalAccessException {
		List<String> list = new ArrayList<>();

		Class<?> clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(o);
			if (value == null) {
				list.add(field.getName());
			}
		}

		return list;
	}

	public static List<String> getAllNotNullAttributes(Object o)
			throws IllegalArgumentException, IllegalAccessException {
		List<String> list = new ArrayList<>();

		Class<?> clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(o);
			if (value != null) {
				list.add(field.getName());
			}
		}

		return list;
	}
}
