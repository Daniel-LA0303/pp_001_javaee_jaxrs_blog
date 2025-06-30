package com.la.javaee.jaxrs.blog.web.category;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;
import com.la.javaee.jaxrs.blog.service.category.CategoryService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categories")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

	@Inject
	private CategoryService categoryService;

	@GET
	public Response getAllCategories() {
		List<CategoryEntity> categories = categoryService.getAll();
		return Response.ok(categories).build();
	}

}
