package com.la.javaee.jaxrs.blog.models.role;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(UserRoleId.class)
@Table(name = "user_role_tbl")
public class UserRoleEntity {

    @Id
    @Column(name = "id_user")
    private Long idUser;

    @Id
    @Column(name = "id_role")
    private Long idRole;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private LocalDateTime createdAt;

	/**
	 * 
	 */
	public UserRoleEntity() {
	}

	/**
	 * @param idUser
	 * @param idRole
	 * @param createdAt
	 */
	public UserRoleEntity(Long idUser, Long idRole, LocalDateTime createdAt) {
		this.idUser = idUser;
		this.idRole = idRole;
		this.createdAt = createdAt;
	}

	/**
	 * return idUser
	 *
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * set the idUser
	 *
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * return idRole
	 *
	 * @return the idRole
	 */
	public Long getIdRole() {
		return idRole;
	}

	/**
	 * set the idRole
	 *
	 * @param idRole the idRole to set
	 */
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	/**
	 * return createdAt
	 *
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * set the createdAt
	 *
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
}
