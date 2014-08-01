package com.reverend.imagePreProcess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reverend.imagePreProcess.dao.AttributeTypeRepository;
import com.reverend.imagePreProcess.dao.AttributeValueRepositry;
import com.reverend.imagePreProcess.model.AttributeType;

@Service
public class AttributeTypeService {

	private AttributeTypeRepository attributeTypeRepository;
	private AttributeValueRepositry attributeValueRepositry;
	
	@Autowired
	public AttributeTypeService(AttributeTypeRepository attributeTypeRepository, AttributeValueRepositry attributeValueRepositry) {
		super();
		this.attributeTypeRepository = attributeTypeRepository;
		this.attributeValueRepositry = attributeValueRepositry;
	}
	
	public Iterable<AttributeType> findAllAttributeTypes(){
		return attributeTypeRepository.findAll();
	}

	public AttributeType save(AttributeType attributeType) {
		attributeType = attributeTypeRepository.save(attributeType);
		return attributeType;
	}
	
	
	
}
