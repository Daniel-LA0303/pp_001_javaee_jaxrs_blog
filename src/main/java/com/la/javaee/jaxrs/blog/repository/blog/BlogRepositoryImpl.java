package com.la.javaee.jaxrs.blog.repository.blog;

import java.util.List;
import java.util.Optional;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class BlogRepositoryImpl implements BlogRepository {

	@Inject
	private EntityManager em;

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BlogEntity> getAll() {
		return em.createQuery("select b from BlogEntity b", BlogEntity.class).getResultList();
	}

	@Override
	public Optional<BlogEntity> getBlogById(Long blogId) {
		try {
			BlogEntity blog = em.createQuery("SELECT b FROM BlogEntity b WHERE b.idBlog = :blogId", BlogEntity.class)
					.setParameter("blogId", blogId).getSingleResult();
			return Optional.ofNullable(blog);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public BlogEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(BlogEntity t) {
		// TODO Auto-generated method stub

	}

}
