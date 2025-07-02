package com.la.javaee.jaxrs.blog.service.blog;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;
import com.la.javaee.jaxrs.blog.utils.dto.blog.BlogDTO;

public interface BlogService {

	public BlogEntity createBlog(BlogDTO blogDTO);

	public List<BlogEntity> getAll();

	public BlogEntity getOneBlog(Long idBlog);

	public BlogEntity updateBlog(Long idBlog, BlogDTO blogDTO);

}
