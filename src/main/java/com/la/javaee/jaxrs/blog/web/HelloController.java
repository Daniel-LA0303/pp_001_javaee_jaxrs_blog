package com.la.javaee.jaxrs.blog.web;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello") // Ruta: /api/hello
public class HelloController {

	@GET
	@Produces(MediaType.APPLICATION_JSON) // Devuelve JSON
	@Path("/hola")
	public Response helloWorld() {
		String jsonResponse = "{\"message\": \"Hello World\"}";
		return Response.ok(jsonResponse).build();
	}
}