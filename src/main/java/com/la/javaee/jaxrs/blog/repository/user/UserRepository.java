package com.la.javaee.jaxrs.blog.repository.user;

import java.util.Optional;

import com.la.javaee.jaxrs.blog.models.user.UserEntity;
import com.la.javaee.jaxrs.blog.repository.CrudRepository;
import com.la.javaee.jaxrs.blog.utils.dto.user.UserDTO;

public interface UserRepository extends CrudRepository<UserEntity> {

	UserEntity createUser(UserDTO userDTO);

	Optional<UserEntity> findByEmail(String email); // Ejemplo adicional
	// Métodos específicos para User

	Optional<UserEntity> findUserById(Long id); // Retorna Optional
}