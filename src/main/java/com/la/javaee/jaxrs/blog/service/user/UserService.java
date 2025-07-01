package com.la.javaee.jaxrs.blog.service.user;

import java.util.List;

import com.la.javaee.jaxrs.blog.models.user.UserEntity;

public interface UserService {

	public List<UserEntity> getAll();

}
