package com.la.javaee.jaxrs.blog.repository.category;

import java.util.Optional;

import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;
import com.la.javaee.jaxrs.blog.repository.CrudRepository;
import com.la.javaee.jaxrs.blog.utils.dto.category.CategoryDTO;

public interface CategoryRepository extends CrudRepository<CategoryEntity> {

	CategoryEntity createCategory(CategoryDTO categoryDTO);

	Optional<CategoryEntity> getByName(String name);

	Optional<CategoryEntity> getCategoryById(Long categoryId);

	CategoryEntity updateCategory(Long categoryId, CategoryDTO categoryDTO);

}
