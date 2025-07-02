package com.la.javaee.jaxrs.blog.exceptions;

import com.la.javaee.jaxrs.blog.utils.ApiResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class GlobalExceptionMapper implements ExceptionMapper<AppException> {
	@Override
	public Response toResponse(AppException e) {
		ApiResponse<Void> response = new ApiResponse<>(e.getStatusCode(), e.getPath(), e.getMethod(), e.getMessage(),
				null, true);
		return Response.status(e.getStatusCode()).entity(response).build();
	}
}