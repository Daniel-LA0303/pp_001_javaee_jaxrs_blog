package com.la.javaee.jaxrs.blog.repository.category;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;
import com.la.javaee.jaxrs.blog.repository.CrudRepository;

import jakarta.enterprise.context.ApplicationScoped;

/*
 * Razón: @ApplicationScoped para repositorios
 * - Normalmente son stateless (dependen de EntityManager que ya maneja concurrencia)
 * - Máxima eficiencia en acceso a datos
 * - EntityManager/JPA ya proporcionan isolation a nivel de transacción
 */
@ApplicationScoped // Singleton durante toda la aplicación
public class CategoryRepository implements CrudRepository<CategoryEntity> {

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CategoryEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CategoryEntity t) {
		// TODO Auto-generated method stub

	}

}
