package com.jetherrodrigues.class5.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validator {
	private static final Logger logger = LoggerFactory.getLogger(Validator.class);

	public static boolean isValidMethod(Object object)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		boolean result = true;

		Class<?> clazz = object.getClass();

		for (Method method : clazz.getMethods()) {
			if (method.getName().startsWith("isValid") && method.getReturnType() == boolean.class) {
				boolean isInvoke = (boolean) method.invoke(object);
				result = result && isInvoke;
			}
		}

		return result;
	}

	public static void isValidMethodTest(Object object)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = object.getClass();

		for (Method method : clazz.getMethods()) {
			if (method.getName().startsWith("test") && method.getReturnType() == void.class
					&& method.getParameterTypes().length == 0)

				try {
					method.invoke(object);
				} catch (InvocationTargetException e) {
					logger.error(e.toString());
				}
		}
	}
}
