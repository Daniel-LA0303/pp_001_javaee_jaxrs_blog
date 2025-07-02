package com.la.javaee.jaxrs.blog.service.blog;

import java.util.List;

import com.la.javaee.jaxrs.blog.exceptions.AppException;
import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;
import com.la.javaee.jaxrs.blog.repository.blog.BlogRepository;
import com.la.javaee.jaxrs.blog.utils.enums.MethodEnum;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class BlogServiceImpl implements BlogService {

	@Inject
	private BlogRepository blogRepository;

	@Override
	public List<BlogEntity> getAll() {
		return blogRepository.getAll();
	}

	@Override
	public BlogEntity getOneBlog(Long idBlog) {
		return blogRepository.getBlogById(idBlog).orElseThrow(() -> new AppException("Blog not found: " + idBlog,
				Response.Status.NOT_FOUND.getStatusCode(), "/api/blogs", MethodEnum.GET));
	}

}
