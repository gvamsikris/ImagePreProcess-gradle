package com.reverend.imagePreProcess.model;

import java.util.Set;

public class AttributeType {

	private String name;
	private Set<AttributeValue> attributeValues;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<AttributeValue> getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(Set<AttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}

}
