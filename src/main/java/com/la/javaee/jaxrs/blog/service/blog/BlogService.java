package com.la.javaee.jaxrs.blog.service.blog;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;

public interface BlogService {

	public List<BlogEntity> getAll();

}
