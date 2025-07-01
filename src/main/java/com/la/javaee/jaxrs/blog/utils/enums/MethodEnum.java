package com.la.javaee.jaxrs.blog.utils.enums;

public enum MethodEnum {
	POST("POST"), PUT("PUT"), DELETE("DELETE"), GET("GET");

	private final String method;

	MethodEnum(String method) {
		this.method = method;
	}

	public String getMethod() {
		return method;
	}

	@Override
	public String toString() {
		return method;
	}
}
