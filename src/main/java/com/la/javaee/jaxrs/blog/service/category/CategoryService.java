package com.la.javaee.jaxrs.blog.service.category;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;

public interface CategoryService {

	public List<CategoryEntity> getAll();

	public CategoryEntity getOneCategory(Long idCategory);

}
