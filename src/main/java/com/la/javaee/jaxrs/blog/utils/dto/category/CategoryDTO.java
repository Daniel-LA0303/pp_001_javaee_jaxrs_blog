package com.la.javaee.jaxrs.blog.utils.dto.category;

public class CategoryDTO {

	/**
	 * name
	 */
	private String name;

	/**
	 * description
	 */
	private String description;

	/**
	 * color
	 */
	private String color;

	/**
	 * value
	 */
	private String value;

	/**
	 * label
	 */
	private String label;

	/**
	 * long description
	 */
	private String longDescription;

	/**
	 * 
	 */
	public CategoryDTO() {
	}

	/**
	 * @param name
	 * @param description
	 * @param color
	 * @param value
	 * @param label
	 * @param longDescription
	 */
	public CategoryDTO(String name, String description, String color, String value, String label,
			String longDescription) {
		this.name = name;
		this.description = description;
		this.color = color;
		this.value = value;
		this.label = label;
		this.longDescription = longDescription;
	}

	/**
	 * return the value of the propertie color
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
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
	 * return the value of the propertie label
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * return the value of the propertie longDescription
	 *
	 * @return the longDescription
	 */
	public String getLongDescription() {
		return longDescription;
	}

	/**
	 * return the value of the propertie name
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * return the value of the propertie value
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * set the value of the proppertie color
	 *
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
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
	 * set the value of the proppertie label
	 *
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * set the value of the proppertie longDescription
	 *
	 * @param longDescription the longDescription to set
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	/**
	 * set the value of the proppertie name
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * set the value of the proppertie value
	 *
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
