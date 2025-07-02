package com.la.javaee.jaxrs.blog.web.blog;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;
import com.la.javaee.jaxrs.blog.service.blog.BlogService;
import com.la.javaee.jaxrs.blog.utils.ApiResponse;
import com.la.javaee.jaxrs.blog.utils.enums.MethodEnum;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

		ApiResponse<List<BlogEntity>> response = new ApiResponse<>(Response.Status.OK.getStatusCode(), // status
				"/api/blogs", // path (ajusta esto según tu endpoint real)
				MethodEnum.GET, // method
				"Blogs retrieved successfully", // message
				blogs, // data
				false // error
		);
		return Response.ok(response).build();
	}

	@GET
	@Path("/{id}")
	public Response getOneBlog(@PathParam("id") Long id) {

		BlogEntity blog = blogService.getOneBlog(id);

		ApiResponse<BlogEntity> response = new ApiResponse<>(Response.Status.OK.getStatusCode(), "/api/blogs/" + id,
				MethodEnum.GET, "Blog retrieved successfully", blog, false);

		return Response.ok(response).build();

	}

}
