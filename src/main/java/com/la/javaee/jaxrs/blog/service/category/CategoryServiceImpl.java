package com.la.javaee.jaxrs.blog.service.category;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;

import jakarta.enterprise.context.ApplicationScoped;

/*
 * Razón: @ApplicationScoped para servicios stateless
 * - Máximo rendimiento (una sola instancia)
 * - Seguro si no mantiene estado interno
 * - Reutilizable entre múltiples requests
 * - Si necesitas transacciones, considera @Transactional de CDI extensions
 */
@ApplicationScoped // Singleton durante toda la aplicación
public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<CategoryEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
