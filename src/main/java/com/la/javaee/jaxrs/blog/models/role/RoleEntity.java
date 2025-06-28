package com.la.javaee.jaxrs.blog.models.role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role_tbl")
public class RoleEntity {

	/**
	 * id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_role", updatable = false)
	private Long idRole;
	
	/**
	 * role name
	 */
	@Column(name = "role_name")
	private String roleName;

	/**
	 * 
	 */
	public RoleEntity() {
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
	 * return roleName
	 *
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * set the roleName
	 *
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
