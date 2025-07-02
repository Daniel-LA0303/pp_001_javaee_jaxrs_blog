package com.la.javaee.jaxrs.blog.exceptions;

import com.la.javaee.jaxrs.blog.utils.enums.MethodEnum;

public class AppException extends RuntimeException {
	private final int statusCode;
	private final String path; // Nuevo campo
	private final MethodEnum method; // Nuevo campo

	// Constructor simplificado (sin errorCode)
	public AppException(String message, int statusCode) {
		this(message, statusCode, null, null);
	}

	public AppException(String message, int statusCode, String path, MethodEnum method) {
		super(message);
		this.statusCode = statusCode;
		this.path = path;
		this.method = method;
	}

	public MethodEnum getMethod() {
		return method;
	}

	public String getPath() {
		return path;
	}

	// Getters
	public int getStatusCode() {
		return statusCode;
	}
}