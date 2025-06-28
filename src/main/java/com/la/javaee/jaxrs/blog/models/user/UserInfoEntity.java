package com.la.javaee.jaxrs.blog.models.user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_info_tbl")
public class UserInfoEntity {
    
	/**
	 * id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_user_info", updatable = false)
	private Long idUserInfo;
	
	/**
	 * profile picture
	 */
	@Column(name = "profile_picture")
	private String profilePicture;
	
	/**
	 * bio
	 */
	@Column(name = "bio")
	private String bio;
	
	/**
	 * last login
	 */
	@Column(name = "last_login")
	private LocalDateTime lastLogin;
	
	/**
	 * is active
	 */
	@Column(name = "is_active")
	private Boolean isActive;
	
	/**
	 * phone
	 */
	@Column(name = "phone")
	private String phone;
	
	/**
	 * direction
	 */
	@Column(name = "direction")
	private String direction;
	
	/**
	 * name
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * last name
	 */
	@Column(name = "last_name")
	private String lastName;
	
	/**
	 * work
	 */
	@Column(name = "work")
	private String work;
	
	/**
	 * education
	 */
	@Column(name = "education")
	private String education;
	
	/**
	 * pronouns
	 */
	@Column(name = "pronouns")
	private String pronouns;
	
	/**
	 * website
	 */
	@Column(name = "website")
	private String website;
	
	/*
	 * city
	 */
	@Column(name = "city")
	private String city;
	
	/**
	 * skills
	 */
	@Column(name = "skills")
	private String skills;
	
	/**
	 * id user
	 */
	@Column(name = "id_user")
	private String idUser;

	/**
	 * 
	 */
	public UserInfoEntity() {
	}

	/**
	 * @param idUserInfo
	 * @param profilePicture
	 * @param bio
	 * @param lastLogin
	 * @param isActive
	 * @param phone
	 * @param direction
	 * @param name
	 * @param lastName
	 * @param work
	 * @param education
	 * @param pronouns
	 * @param website
	 * @param city
	 * @param skills
	 * @param idUser
	 */
	public UserInfoEntity(Long idUserInfo, String profilePicture, String bio, LocalDateTime lastLogin, Boolean isActive,
			String phone, String direction, String name, String lastName, String work, String education,
			String pronouns, String website, String city, String skills, String idUser) {
		this.idUserInfo = idUserInfo;
		this.profilePicture = profilePicture;
		this.bio = bio;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
		this.phone = phone;
		this.direction = direction;
		this.name = name;
		this.lastName = lastName;
		this.work = work;
		this.education = education;
		this.pronouns = pronouns;
		this.website = website;
		this.city = city;
		this.skills = skills;
		this.idUser = idUser;
	}

	/**
	 * return idUserInfo
	 *
	 * @return the idUserInfo
	 */
	public Long getIdUserInfo() {
		return idUserInfo;
	}

	/**
	 * set the idUserInfo
	 *
	 * @param idUserInfo the idUserInfo to set
	 */
	public void setIdUserInfo(Long idUserInfo) {
		this.idUserInfo = idUserInfo;
	}

	/**
	 * return profilePicture
	 *
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * set the profilePicture
	 *
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	/**
	 * return bio
	 *
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * set the bio
	 *
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * return lastLogin
	 *
	 * @return the lastLogin
	 */
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	/**
	 * set the lastLogin
	 *
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * return isActive
	 *
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * set the isActive
	 *
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * return phone
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * set the phone
	 *
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * return direction
	 *
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * set the direction
	 *
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * return name
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the name
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * return lastName
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set the lastName
	 *
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * return work
	 *
	 * @return the work
	 */
	public String getWork() {
		return work;
	}

	/**
	 * set the work
	 *
	 * @param work the work to set
	 */
	public void setWork(String work) {
		this.work = work;
	}

	/**
	 * return education
	 *
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * set the education
	 *
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * return pronouns
	 *
	 * @return the pronouns
	 */
	public String getPronouns() {
		return pronouns;
	}

	/**
	 * set the pronouns
	 *
	 * @param pronouns the pronouns to set
	 */
	public void setPronouns(String pronouns) {
		this.pronouns = pronouns;
	}

	/**
	 * return website
	 *
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * set the website
	 *
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * return city
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * set the city
	 *
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * return skills
	 *
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * set the skills
	 *
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}

	/**
	 * return idUser
	 *
	 * @return the idUser
	 */
	public String getIdUser() {
		return idUser;
	}

	/**
	 * set the idUser
	 *
	 * @param idUser the idUser to set
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

}
