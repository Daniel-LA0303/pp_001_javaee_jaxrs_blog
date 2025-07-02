package com.la.javaee.jaxrs.blog.service.category;

import java.util.List;

import com.la.javaee.jaxrs.blog.exceptions.AppException;
import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;
import com.la.javaee.jaxrs.blog.repository.category.CategoryRepository;
import com.la.javaee.jaxrs.blog.utils.dto.category.CategoryDTO;
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
	public CategoryEntity createCategory(CategoryDTO categoryDTO) {
		// Verificar si ya existe una categoría con ese nombre
		categoryRepository.getByName(categoryDTO.getName()).ifPresent(existing -> {
			throw new AppException("Category name already exists: " + categoryDTO.getName(),
					Response.Status.CONFLICT.getStatusCode(), "/api/categories", MethodEnum.POST);
		});

		// Si no existe, creamos la categoría
		return categoryRepository.createCategory(categoryDTO);
	}

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

	@Override
	public CategoryEntity updateCategory(Long idCategory, CategoryDTO categoryDTO) {

		// Buscar categoría existente
		categoryRepository.getCategoryById(idCategory)
				.orElseThrow(() -> new AppException("Category not found: " + idCategory,
						Response.Status.NOT_FOUND.getStatusCode(), "/api/categories/" + idCategory, MethodEnum.PUT));

		// Verificar duplicado por nombre (y evitar que lo compare con sí misma)
		categoryRepository.getByName(categoryDTO.getName()).ifPresent(duplicate -> {
			if (!duplicate.getIdCategory().equals(idCategory)) {
				throw new AppException("Category name already exists: " + categoryDTO.getName(),
						Response.Status.CONFLICT.getStatusCode(), "/api/categories/" + idCategory, MethodEnum.PUT);
			}
		});

		// Realizar actualización
		return categoryRepository.updateCategory(idCategory, categoryDTO);
	}

}
