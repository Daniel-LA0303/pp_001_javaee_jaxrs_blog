package com.la.javaee.jaxrs.blog.repository.blog;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;
import com.la.javaee.jaxrs.blog.repository.CrudRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class BlogRepository implements CrudRepository<BlogEntity> {

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
	public BlogEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(BlogEntity t) {
		// TODO Auto-generated method stub

	}

}
