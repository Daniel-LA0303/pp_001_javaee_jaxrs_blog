package com.la.javaee.jaxrs.blog.models.blog;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog_tbl")
public class BlogEntity {

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_blog", updatable = false)
	private Long idBlog;

	/**
	 * title
	 */
	@Column(name = "title")
	private String title;

	/**
	 * description
	 */
	@Column(name = "descirption")
	private String description;

	/**
	 * content
	 */
	@Column(name = "content")
	private String content;

	/**
	 * status
	 */
	@Column(name = "status")
	private String status;

	/**
	 * minutes to read
	 */
	@Column(name = "min_read")
	private String minRead;

	/**
	 * blog img url
	 */
	@Column(name = "blog_img_url")
	private String blogImgURL;

	/**
	 * slug
	 */
	@Column(name = "slug")
	private String slug;

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
	 * id user
	 */
	@Column(name = "id_user", nullable = false)
	private Long userId;

	@ManyToMany(fetch = FetchType.EAGER) // O FetchType.EAGER si siempre necesitas categorías
	@JoinTable(name = "blog_category_tbl", // Tabla intermedia
			joinColumns = @JoinColumn(name = "id_blog"), // FK de Blog
			inverseJoinColumns = @JoinColumn(name = "id_category") // FK de Category
	)
	private Set<CategoryEntity> categories = new HashSet<>();

	/**
	 * 
	 */
	public BlogEntity() {
	}

	/**
	 * @param idBlog
	 * @param title
	 * @param description
	 * @param content
	 * @param status
	 * @param minRead
	 * @param blogImgURL
	 * @param slug
	 * @param createdAt
	 * @param updatedAt
	 * @param userId
	 * @param categories
	 */
	public BlogEntity(Long idBlog, String title, String description, String content, String status, String minRead,
			String blogImgURL, String slug, LocalDateTime createdAt, LocalDateTime updatedAt, Long userId,
			Set<CategoryEntity> categories) {
		this.idBlog = idBlog;
		this.title = title;
		this.description = description;
		this.content = content;
		this.status = status;
		this.minRead = minRead;
		this.blogImgURL = blogImgURL;
		this.slug = slug;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userId = userId;
		this.categories = categories;
	}

	/**
	 * return blogImgURL
	 *
	 * @return the blogImgURL
	 */
	public String getBlogImgURL() {
		return blogImgURL;
	}

	/**
	 * return categories
	 *
	 * @return the categories
	 */
	public Set<CategoryEntity> getCategories() {
		return categories;
	}

	/**
	 * return content
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
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
	 * return description
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * return idBlog
	 *
	 * @return the idBlog
	 */
	public Long getIdBlog() {
		return idBlog;
	}

	/**
	 * return minRead
	 *
	 * @return the minRead
	 */
	public String getMinRead() {
		return minRead;
	}

	/**
	 * return slug
	 *
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * return status
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * return title
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
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
	 * return userId
	 *
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * set the blogImgURL
	 *
	 * @param blogImgURL the blogImgURL to set
	 */
	public void setBlogImgURL(String blogImgURL) {
		this.blogImgURL = blogImgURL;
	}

	/**
	 * set the categories
	 *
	 * @param categories the categories to set
	 */
	public void setCategories(Set<CategoryEntity> categories) {
		this.categories = categories;
	}

	/**
	 * set the content
	 *
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * set the description
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * set the idBlog
	 *
	 * @param idBlog the idBlog to set
	 */
	public void setIdBlog(Long idBlog) {
		this.idBlog = idBlog;
	}

	/**
	 * set the minRead
	 *
	 * @param minRead the minRead to set
	 */
	public void setMinRead(String minRead) {
		this.minRead = minRead;
	}

	/**
	 * set the slug
	 *
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * set the status
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * set the title
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * set the updatedAt
	 *
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * set the userId
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
