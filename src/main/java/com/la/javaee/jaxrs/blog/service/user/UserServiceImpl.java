package com.la.javaee.jaxrs.blog.service.user;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.user.UserEntity;
import com.la.javaee.jaxrs.blog.repository.CrudRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserServiceImpl implements UserService {

	@Inject
	private CrudRepository<UserEntity> userRepository;

	@Override
	public List<UserEntity> getAll() {
		return userRepository.getAll();
	}

}
