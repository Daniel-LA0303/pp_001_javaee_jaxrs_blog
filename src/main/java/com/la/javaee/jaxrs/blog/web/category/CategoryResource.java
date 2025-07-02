package com.la.javaee.jaxrs.blog.web.category;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;
import com.la.javaee.jaxrs.blog.service.category.CategoryService;
import com.la.javaee.jaxrs.blog.utils.ApiResponse;
import com.la.javaee.jaxrs.blog.utils.dto.category.CategoryDTO;
import com.la.javaee.jaxrs.blog.utils.enums.MethodEnum;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

	@POST
	public Response createCategory(CategoryDTO categoryDTO) {

		CategoryEntity categoryEntity = categoryService.createCategory(categoryDTO);

		ApiResponse<CategoryEntity> response = new ApiResponse<>(Response.Status.CREATED.getStatusCode(),
				"/api/categories/", MethodEnum.POST, "Category created successfully", categoryEntity, false);

		return Response.ok(response).build();
	}

	@GET
	public Response getAllCategories() {
		List<CategoryEntity> categories = categoryService.getAll();

		ApiResponse<List<CategoryEntity>> response = new ApiResponse<>(Response.Status.OK.getStatusCode(), // status
				"/api/categories", // path (ajusta esto según tu endpoint real)
				MethodEnum.GET, // method
				"Categories retrieved successfully", // message
				categories, // data
				false // error
		);

		return Response.ok(response).build();
	}

	@GET
	@Path("/{id}")
	public Response getOneCategory(@PathParam("id") Long id) {

		CategoryEntity category = categoryService.getOneCategory(id);

		ApiResponse<CategoryEntity> response = new ApiResponse<>(Response.Status.OK.getStatusCode(),
				"/api/categories/" + id, // Ruta
											// dinámica
				MethodEnum.GET, "Category retrieved successfully", category, false);

		return Response.ok(response).build();

	}

	@PUT
	@Path("/{id}")
	public Response updateCategory(@PathParam("id") Long id, CategoryDTO categoryDTO) {
		CategoryEntity updated = categoryService.updateCategory(id, categoryDTO);
		ApiResponse<CategoryEntity> response = new ApiResponse<>(Response.Status.OK.getStatusCode(),
				"/api/categories/" + id, MethodEnum.PUT, "Category updated successfully", updated, false);
		return Response.ok(response).build();
	}

}
