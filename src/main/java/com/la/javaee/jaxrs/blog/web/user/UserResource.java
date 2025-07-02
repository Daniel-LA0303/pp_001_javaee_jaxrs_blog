package com.la.javaee.jaxrs.blog.web.user;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.user.UserEntity;
import com.la.javaee.jaxrs.blog.service.user.UserService;
import com.la.javaee.jaxrs.blog.utils.ApiResponse;
import com.la.javaee.jaxrs.blog.utils.dto.user.UserDTO;
import com.la.javaee.jaxrs.blog.utils.enums.MethodEnum;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

	@POST
	public Response createUser(UserDTO userDTO) {

		UserEntity createdUser = userService.createUser(userDTO);

		ApiResponse<UserEntity> response = new ApiResponse<>(Response.Status.CREATED.getStatusCode(), "/api/users/",
				MethodEnum.POST, "User created successfully", createdUser, false);

		return Response.ok(response).build();
	}

	@GET
	public Response getAllUsers() {
		List<UserEntity> users = userService.getAll();

		ApiResponse<List<UserEntity>> response = new ApiResponse<>(Response.Status.OK.getStatusCode(), // status
				"/api/categories", // path (ajusta esto según tu endpoint real)
				MethodEnum.GET, // method
				"Categories retrieved successfully", // message
				users, // data
				false // error
		);

		return Response.ok(response).build();
	}

	@GET
	@Path("/{id}")
	public Response getOneUser(@PathParam("id") Long id) {

		UserEntity user = userService.getOneUser(id);

		ApiResponse<UserEntity> response = new ApiResponse<>(Response.Status.OK.getStatusCode(), "/api/users/" + id, // Ruta
																														// dinámica
				MethodEnum.GET, "User retrieved successfully", user, false);

		return Response.ok(response).build();

	}

}
