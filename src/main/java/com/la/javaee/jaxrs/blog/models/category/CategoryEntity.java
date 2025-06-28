package com.la.javaee.jaxrs.blog.models.category;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category_tbl")
public class CategoryEntity {
	
	/**
	 * id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_category", updatable = false)
	private Long idCategory;
	
	/**
	 * name
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * description
	 */
	@Column(name = "description")
	private String description;
	
	/**
	 * color
	 */
	@Column(name = "color")
	private String color;
	
	/**
	 * value
	 */
	@Column(name = "value")
	private String value;
	
	/**
	 * label
	 */
	@Column(name = "label")
	private String label;
	
	/**
	 * long description
	 */
	@Column(name = "long_description")
	private String longDescription;
	
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
	public CategoryEntity() {
	}

	/**
	 * @param idCategory
	 * @param name
	 * @param description
	 * @param color
	 * @param value
	 * @param label
	 * @param longDescription
	 * @param createdAt
	 * @param updatedAt
	 */
	public CategoryEntity(Long idCategory, String name, String description, String color, String value, String label,
			String longDescription, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.idCategory = idCategory;
		this.name = name;
		this.description = description;
		this.color = color;
		this.value = value;
		this.label = label;
		this.longDescription = longDescription;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	/**
	 * return idCategory
	 *
	 * @return the idCategory
	 */
	public Long getIdCategory() {
		return idCategory;
	}

	/**
	 * set the idCategory
	 *
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
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
	 * return description
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * return color
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * set the color
	 *
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * return value
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * set the value
	 *
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * return label
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * set the label
	 *
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * return longDescription
	 *
	 * @return the longDescription
	 */
	public String getLongDescription() {
		return longDescription;
	}

	/**
	 * set the longDescription
	 *
	 * @param longDescription the longDescription to set
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
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
