package com.la.javaee.jaxrs.blog.service.user;

import java.util.List;

import com.la.javaee.jaxrs.blog.exceptions.AppException;
import com.la.javaee.jaxrs.blog.models.user.UserEntity;
import com.la.javaee.jaxrs.blog.repository.user.UserRepository;
import com.la.javaee.jaxrs.blog.utils.dto.user.UserDTO;
import com.la.javaee.jaxrs.blog.utils.enums.MethodEnum;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository userRepository;

	@Override
	public UserEntity createUser(UserDTO userDTO) {
		return userRepository.createUser(userDTO);
	}

	@Override
	public List<UserEntity> getAll() {
		return userRepository.getAll();
	}

	@Override
	public UserEntity getOneUser(Long id) {
		return userRepository.findUserById(id).orElseThrow(() -> new AppException("User not found: " + id,
				Response.Status.NOT_FOUND.getStatusCode(), "/api/users", MethodEnum.GET));
	}

}
