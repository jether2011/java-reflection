package com.jetherrodrigues.class5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validator {
	public static boolean isValidMethod(Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		boolean result = true;
		
		Class<?> clazz = object.getClass();
		
		for (Method method : clazz.getMethods()) {
			if(method.getName().startsWith("isValid") && 
					method.getReturnType() == boolean.class){
				boolean isInvoke = (boolean) method.invoke(object);
				result = result && isInvoke;
			}
		}
		
		return result;
	}
	
	public static boolean isValidMethodTest(Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		boolean result = true;
		
		Class<?> clazz = object.getClass();
		
		for (Method method : clazz.getMethods()) {
			if(method.getName().startsWith("test") && 
					method.getReturnType() == void.class){
				result = result && true;
			}
		}
		
		return result;
	}
}
