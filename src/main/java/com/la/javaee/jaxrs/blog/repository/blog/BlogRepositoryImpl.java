package com.la.javaee.jaxrs.blog.repository.blog;

import java.util.List;
import java.util.Optional;

import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BlogRepositoryImpl implements BlogRepository {

	@Inject
	private EntityManager em;

	@Override
	@Transactional
	public BlogEntity createBlog(BlogEntity blogEntity) {

		em.persist(blogEntity);
		return blogEntity;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsBySlug(String slug) {
		String jpql = "SELECT COUNT(b) FROM BlogEntity b WHERE b.slug = :slug";
		Long count = em.createQuery(jpql, Long.class).setParameter("slug", slug).getSingleResult();
		return count > 0;
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
	public Optional<BlogEntity> getBySlug(String slug) {
		try {
			BlogEntity blog = em.createQuery("SELECT b FROM BlogEntity b WHERE b.slug = :slug", BlogEntity.class)
					.setParameter("slug", slug).getSingleResult();
			return Optional.of(blog);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<BlogEntity> getByTitle(String title) {
		try {
			BlogEntity blog = em.createQuery("SELECT c FROM BlogEntity c WHERE c.title = :title", BlogEntity.class)
					.setParameter("title", title).getSingleResult();
			return Optional.of(blog);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public void save(BlogEntity t) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public BlogEntity updateBlog(Long blogId, BlogEntity updatedData) {
		BlogEntity existing = em.find(BlogEntity.class, blogId);
		if (existing != null) {
			existing.setTitle(updatedData.getTitle());
			existing.setDescription(updatedData.getDescription());
			existing.setContent(updatedData.getContent());
			existing.setCategories(updatedData.getCategories());
			existing.setMinRead(updatedData.getMinRead());
			existing.setUpdatedAt(updatedData.getUpdatedAt());

			// No se modifica: userId, slug, createdAt, blogImgURL, status

			em.merge(existing);
		}
		return existing;
	}
}
