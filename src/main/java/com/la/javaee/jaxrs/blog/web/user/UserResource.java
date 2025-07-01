package com.la.javaee.jaxrs.blog.web.user;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.user.UserEntity;
import com.la.javaee.jaxrs.blog.service.user.UserService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	@Inject
	private UserService userService;

	@GET
	public Response getAllUsers() {
		List<UserEntity> users = userService.getAll();
		return Response.ok(users).build();
	}

}
