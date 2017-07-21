package com.jetherrodrigues.class3;

import com.jetherrodrigues.util.GsonSingleton;

public class Class3Impl implements Class3Interface {

	private String name;

	public Class3Impl(String name) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}

}
