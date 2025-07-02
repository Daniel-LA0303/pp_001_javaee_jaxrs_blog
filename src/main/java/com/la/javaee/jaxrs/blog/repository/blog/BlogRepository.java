package com.la.javaee.jaxrs.blog.repository.blog;

import java.util.Optional;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;
import com.la.javaee.jaxrs.blog.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<BlogEntity> {

	BlogEntity createBlog(BlogEntity blogEntity);

	boolean existsBySlug(String slug);

	Optional<BlogEntity> getBlogById(Long blogId);

	Optional<BlogEntity> getBySlug(String slug);

	Optional<BlogEntity> getByTitle(String Titlte);

	BlogEntity updateBlog(Long blogId, BlogEntity updatedData);

}
