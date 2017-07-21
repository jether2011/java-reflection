package com.jetherrodrigues.class6.exceptions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jetherrodrigues.class5.methods.ExecutorClass5;

@SuppressWarnings("unused")
public class TestException {

	private static final Logger logger = LoggerFactory.getLogger(ExecutorClass5.class);

	public static void main(String[] args) {
		TestException exception = new TestException();

		Class<?> clazz = exception.getClass();
		Method method = null;

		try {
			method = clazz.getMethod("doAnyThing");
		} catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
			logger.error(e.toString());
		}

		try {
			method = clazz.getDeclaredMethod("doAnyThingAgain");
		} catch (IllegalAccessError | NoSuchMethodException | SecurityException e) {
			logger.error(e.toString());
		}

		try {
			method = clazz.getDeclaredMethod("doAnyThingAgain", String.class);
			method.invoke(exception);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			logger.error(e.toString());
		}
		
	}

	public void doAnyThing(String value) {

	}

	private void doAnyThingAgain(String value) {

	}
}
