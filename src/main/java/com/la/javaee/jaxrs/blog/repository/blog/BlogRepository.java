package com.la.javaee.jaxrs.blog.repository.blog;

import java.util.Optional;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;
import com.la.javaee.jaxrs.blog.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<BlogEntity> {

	Optional<BlogEntity> getBlogById(Long blogId);

}
