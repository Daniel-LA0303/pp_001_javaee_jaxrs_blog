package com.la.javaee.jaxrs.blog.service.category;

import java.util.List;
import java.util.Set;

import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;
import com.la.javaee.jaxrs.blog.utils.dto.category.CategoryDTO;

public interface CategoryService {

	public CategoryEntity createCategory(CategoryDTO categoryDTO);

	public List<CategoryEntity> getAll();

	public CategoryEntity getOneCategory(Long idCategory);

	public CategoryEntity updateCategory(Long idCategory, CategoryDTO categoryDTO);

	public List<CategoryEntity> validateCategories(Set<Long> categoryIds);

}
