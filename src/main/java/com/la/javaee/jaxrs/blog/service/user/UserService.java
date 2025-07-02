package com.la.javaee.jaxrs.blog.service.user;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.user.UserEntity;
import com.la.javaee.jaxrs.blog.utils.dto.user.UserDTO;

public interface UserService {

	public UserEntity createUser(UserDTO userDTO);

	public List<UserEntity> getAll();

	public UserEntity getOneUser(Long idUser);

}
