package com.la.javaee.jaxrs.blog.config.producers.dbConfig;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityManager {

	@PersistenceContext()
	private EntityManager em;

	@Produces
	@RequestScoped
	private EntityManager beanEntityManger() {
		return em;
	}

}
