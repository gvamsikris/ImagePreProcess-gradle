package com.reverend.imagePreProcess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reverend.imagePreProcess.dao.AttributeHome;
import com.reverend.imagePreProcess.dao.AttributeTypeHome;
import com.reverend.imagePreProcess.dao.AttributeValueHome;
import com.reverend.imagePreProcess.dao.BatchHome;
import com.reverend.imagePreProcess.dao.ImageHome;
import com.reverend.imagePreProcess.dao.ProjectHome;

@Service
public class ModelService {

	private ProjectHome projectHome;
	private BatchHome batchHome;
	private ImageHome imageHome;
	private AttributeHome attributeHome;

	private AttributeTypeHome attributeTypeHome;
	private AttributeValueHome attributeValueHome;

	@Autowired
	public ProjectHome getProjectHome() {
		return projectHome;
	}

	public void setProjectHome(ProjectHome projectHome) {
		this.projectHome = projectHome;
	}

	@Autowired
	public BatchHome getBatchHome() {
		return batchHome;
	}

	public void setBatchHome(BatchHome batchHome) {
		this.batchHome = batchHome;
	}

	@Autowired
	public ImageHome getImageHome() {
		return imageHome;
	}

	public void setImageHome(ImageHome imageHome) {
		this.imageHome = imageHome;
	}

	@Autowired
	public AttributeHome getAttributeHome() {
		return attributeHome;
	}

	public void setAttributeHome(AttributeHome attributeHome) {
		this.attributeHome = attributeHome;
	}

	@Autowired
	public AttributeTypeHome getAttributeTypeHome() {
		return attributeTypeHome;
	}

	public void setAttributeTypeHome(AttributeTypeHome attributeTypeHome) {
		this.attributeTypeHome = attributeTypeHome;
	}

	@Autowired
	public AttributeValueHome getAttributeValueHome() {
		return attributeValueHome;
	}

	public void setAttributeValueHome(AttributeValueHome attributeValueHome) {
		this.attributeValueHome = attributeValueHome;
	}

}
