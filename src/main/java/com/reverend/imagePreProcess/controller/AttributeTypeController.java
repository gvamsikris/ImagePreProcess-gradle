package com.reverend.imagePreProcess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reverend.imagePreProcess.model.AttributeType;
import com.reverend.imagePreProcess.service.AttributeTypeService;

@Controller
@RequestMapping("/attributeType")
public class AttributeTypeController {

	@Autowired
	private AttributeTypeService attributeTypeService;

	@RequestMapping("/list")
	public @ResponseBody Iterable<AttributeType> findAll() {
		Iterable<AttributeType> allAttributeTypes = attributeTypeService.findAllAttributeTypes();
		return allAttributeTypes;
	}

}
