package com.la.javaee.jaxrs.blog.repository.user;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.user.UserEntity;
import com.la.javaee.jaxrs.blog.repository.CrudRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class UserRepository implements CrudRepository<UserEntity> {

	@Inject
	private EntityManager em;

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserEntity> getAll() {

		return em.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
	}

	@Override
	public UserEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserEntity t) {
		// TODO Auto-generated method stub

	}

}
