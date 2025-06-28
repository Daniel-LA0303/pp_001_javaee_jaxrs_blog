package com.la.javaee.jaxrs.blog.models.user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class UserEntity {
	
	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	
	/**
	 * username
	 */
	@Column(name = "username")
	private String username;
	
	/**
	 * email
	 */
	@Column(name = "email")
	private String email;
	
	/**
	 * password
	 */
	@Column(name = "password")
	private String password;
	
	/**
	 * created at
	 */
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	/**
	 * updated at
	 */
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	/**
	 * 
	 */
	public UserEntity() {
	}

	/**
	 * @param id_user
	 * @param username
	 * @param email
	 * @param password
	 * @param createdAt
	 * @param updatedAt
	 */
	public UserEntity(Long id_user, String username, String email, String password, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.id_user = id_user;
		this.username = username;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	/**
	 * return id_user
	 *
	 * @return the id_user
	 */
	public Long getId_user() {
		return id_user;
	}

	/**
	 * set the id_user
	 *
	 * @param id_user the id_user to set
	 */
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	/**
	 * return username
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * set the username
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * return email
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * set the email
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * return password
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set the password
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * return updatedAt
	 *
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * set the updatedAt
	 *
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
