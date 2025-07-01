package com.la.javaee.jaxrs.blog.service.blog;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;
import com.la.javaee.jaxrs.blog.repository.blog.BlogRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BlogServiceImpl implements BlogService {

	@Inject
	private BlogRepository blogRepository;

	@Override
	public List<BlogEntity> getAll() {
		return blogRepository.getAll();
	}

}
