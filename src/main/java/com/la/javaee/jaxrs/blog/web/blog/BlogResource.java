package com.la.javaee.jaxrs.blog.web.blog;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;
import com.la.javaee.jaxrs.blog.service.blog.BlogService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/blogs")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlogResource {

	@Inject
	private BlogService blogService;

	@GET
	public Response getAllCategories() {
		List<BlogEntity> blogs = blogService.getAll();
		return Response.ok(blogs).build();
	}

}
