package com.la.javaee.jaxrs.blog.utils.dto.blog;

import java.util.Set;

public class BlogDTO {

	/**
	 * title
	 */
	private String title;

	/**
	 * description
	 */
	private String description;

	/**
	 * content
	 */
	private String content;

	/**
	 * categories
	 */
	private Set<Long> categories;

	/**
	 * user
	 */
	private Long userId;

	/**
	 * 
	 */
	public BlogDTO() {
	}

	/**
	 * @param title
	 * @param description
	 * @param content
	 * @param categories
	 * @param userId
	 */
	public BlogDTO(String title, String description, String content, Set<Long> categories, Long userId) {
		this.title = title;
		this.description = description;
		this.content = content;
		this.categories = categories;
		this.userId = userId;
	}

	/**
	 * return the value of the propertie categories
	 *
	 * @return the categories
	 */
	public Set<Long> getCategories() {
		return categories;
	}

	/**
	 * return the value of the propertie content
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * return the value of the propertie description
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * return the value of the propertie title
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * return the value of the propertie userId
	 *
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * set the value of the proppertie categories
	 *
	 * @param categories the categories to set
	 */
	public void setCategories(Set<Long> categories) {
		this.categories = categories;
	}

	/**
	 * set the value of the proppertie content
	 *
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * set the value of the proppertie description
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * set the value of the proppertie title
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * set the value of the proppertie userId
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
