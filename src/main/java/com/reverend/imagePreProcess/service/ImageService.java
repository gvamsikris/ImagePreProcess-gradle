package com.reverend.imagePreProcess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reverend.imagePreProcess.dao.AttributeRepsoitory;
import com.reverend.imagePreProcess.dao.ImageRepository;

@Service
public class ImageService {
	
	private ImageRepository imageRepository;
	private AttributeRepsoitory attributeRepsoitory;
	
	@Autowired
	public ImageService(ImageRepository imageRepository, AttributeRepsoitory attributeRepsoitory) {
		this.imageRepository = imageRepository;
		this.attributeRepsoitory = attributeRepsoitory;
	}
	
}
