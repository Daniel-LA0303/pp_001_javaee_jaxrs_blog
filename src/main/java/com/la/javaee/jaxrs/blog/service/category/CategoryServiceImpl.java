package com.la.javaee.jaxrs.blog.service.category;

import java.util.List;

import com.la.javaee.jaxrs.blog.exceptions.AppException;
import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;
import com.la.javaee.jaxrs.blog.repository.category.CategoryRepository;
import com.la.javaee.jaxrs.blog.utils.enums.MethodEnum;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

/*
 * Razón: @ApplicationScoped para servicios stateless
 * - Máximo rendimiento (una sola instancia)
 * - Seguro si no mantiene estado interno
 * - Reutilizable entre múltiples requests
 * - Si necesitas transacciones, considera @Transactional de CDI extensions
 */
@ApplicationScoped // Singleton durante toda la aplicación
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryEntity> getAll() {
		// TODO Auto-generated method stub
		return categoryRepository.getAll();
	}

	@Override
	public CategoryEntity getOneCategory(Long idCategory) {
		return categoryRepository.getCategoryById(idCategory)
				.orElseThrow(() -> new AppException("Category not found: " + idCategory,
						Response.Status.NOT_FOUND.getStatusCode(), "/api/categories", MethodEnum.GET));
	}

}
