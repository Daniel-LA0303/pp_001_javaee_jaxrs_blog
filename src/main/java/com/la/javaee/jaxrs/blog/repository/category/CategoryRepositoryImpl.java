package com.la.javaee.jaxrs.blog.repository.category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;
import com.la.javaee.jaxrs.blog.utils.dto.category.CategoryDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

/*
 * Razón: @ApplicationScoped para repositorios
 * - Normalmente son stateless (dependen de EntityManager que ya maneja concurrencia)
 * - Máxima eficiencia en acceso a datos
 * - EntityManager/JPA ya proporcionan isolation a nivel de transacción
 */
@ApplicationScoped // Singleton durante toda la aplicación
public class CategoryRepositoryImpl implements CategoryRepository {
	@Inject
	private EntityManager em;

	@Override
	@Transactional
	public CategoryEntity createCategory(CategoryDTO categoryDTO) {

		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setColor(categoryDTO.getColor());
		categoryEntity.setCreatedAt(LocalDateTime.now());
		categoryEntity.setDescription(categoryDTO.getDescription());
		categoryEntity.setLabel(categoryDTO.getLabel());
		categoryEntity.setLongDescription(categoryDTO.getLongDescription());
		categoryEntity.setName(categoryDTO.getName());
		categoryEntity.setUpdatedAt(LocalDateTime.now());
		categoryEntity.setValue(categoryDTO.getValue());

		em.persist(categoryEntity);

		return categoryEntity;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CategoryEntity> getAll() {

		return em.createQuery("select c from CategoryEntity c", CategoryEntity.class).getResultList();
	}

	@Override
	public CategoryEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CategoryEntity> getByName(String name) {
		try {
			CategoryEntity category = em
					.createQuery("SELECT c FROM CategoryEntity c WHERE c.name = :name", CategoryEntity.class)
					.setParameter("name", name).getSingleResult();
			return Optional.of(category);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<CategoryEntity> getCategoryById(Long categoryId) {
		try {
			CategoryEntity category = em.createQuery("SELECT c FROM CategoryEntity c WHERE c.idCategory = :categoryId",
					CategoryEntity.class).setParameter("categoryId", categoryId).getSingleResult();
			return Optional.ofNullable(category);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public void save(CategoryEntity t) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public CategoryEntity updateCategory(Long categoryId, CategoryDTO categoryDTO) {
		CategoryEntity category = em.find(CategoryEntity.class, categoryId);

		if (category != null) {
			category.setName(categoryDTO.getName());
			category.setDescription(categoryDTO.getDescription());
			category.setColor(categoryDTO.getColor());
			category.setValue(categoryDTO.getValue());
			category.setLabel(categoryDTO.getLabel());
			category.setLongDescription(categoryDTO.getLongDescription());

			em.merge(category);
		}

		return category;
	}

}
