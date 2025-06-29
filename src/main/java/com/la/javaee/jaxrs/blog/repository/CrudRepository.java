package com.la.javaee.jaxrs.blog.repository;

import java.util.List;

public interface CrudRepository<T> {

	public void delete(Long id);

	public List<T> getAll();

	public T getById(Long id);

	public void save(T t);

}
