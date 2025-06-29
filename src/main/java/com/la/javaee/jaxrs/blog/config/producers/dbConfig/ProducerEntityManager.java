package com.la.javaee.jaxrs.blog.config.producers.dbConfig;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Productor de EntityManager para inyección CDI.
 * 
 * Razón de ser ApplicationScoped: 1. El producer mismo es stateless - solo
 * sirve como fábrica 2. La instancia de EntityManager producida puede tener
 * diferente scope 3. Optimización de recursos - no necesita recrearse por cada
 * request
 */
@RequestScoped
public class ProducerEntityManager {

	/**
	 * Inyectamos el EntityManager estándar de JPA.
	 * 
	 * El @PersistenceContext: 1. Proporciona un proxy manejado por el contenedor 2.
	 * Maneja automáticamente la conexión al pool 3. Soporta transacciones JTA
	 * automáticas
	 * 
	 * unitName es obligatorio si tienes múltiples persistence units
	 */
	@PersistenceContext(unitName = "blogPU")
	private EntityManager em;

	/**
	 * Método productor que hace el EntityManager disponible para @Inject.
	 * 
	 * Por qué usar @Produces: 1. Permite usar @Inject en lugar
	 * de @PersistenceContext 2. Centraliza la configuración del EntityManager 3.
	 * Facilita la personalización (ej: filtros, interceptores)
	 * 
	 * Nota: El scope del EM producido lo determina el contenedor JPA (normalmente
	 * es request-scoped implícitamente)
	 */
	@Produces
	public EntityManager produceEntityManager() {
		return em; // Retorna el proxy administrado por el contenedor
	}

}
