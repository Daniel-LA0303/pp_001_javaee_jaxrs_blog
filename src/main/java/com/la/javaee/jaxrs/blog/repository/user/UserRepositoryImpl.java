package com.la.javaee.jaxrs.blog.repository.user;

import java.util.List;
import java.util.Optional;

import com.la.javaee.jaxrs.blog.models.user.UserEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

	@Inject
	private EntityManager em;

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<UserEntity> findByEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<UserEntity> findUserById(Long id) {
		try {
			UserEntity user = em.createQuery("SELECT u FROM UserEntity u WHERE u.id_user = :id", UserEntity.class)
					.setParameter("id", id).getSingleResult();
			return Optional.ofNullable(user);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<UserEntity> getAll() {
		return em.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
	}

	@Override
	public UserEntity getById(Long id) {
		return null;
	}

	@Override
	public void save(UserEntity t) {
		// TODO Auto-generated method stub

	}

}
