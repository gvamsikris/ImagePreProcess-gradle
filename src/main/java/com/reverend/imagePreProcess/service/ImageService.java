package com.reverend.imagePreProcess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reverend.imagePreProcess.dao.AttributeRepsoitory;
import com.reverend.imagePreProcess.dao.BatchRepository;
import com.reverend.imagePreProcess.dao.ImageRepository;
import com.reverend.imagePreProcess.model.Batch;
import com.reverend.imagePreProcess.model.Image;

@Service
public class ImageService {
	
	private ImageRepository imageRepository;
	private AttributeRepsoitory attributeRepsoitory;
	private BatchRepository batchRepository;
	
	@Autowired
	public ImageService(BatchRepository batchRepository, ImageRepository imageRepository, AttributeRepsoitory attributeRepsoitory) {
		this.batchRepository = batchRepository;
		this.imageRepository = imageRepository;
		this.attributeRepsoitory = attributeRepsoitory;
	}
	
	public Image findImage(Long id){
		return imageRepository.findOne(id);
	}
	
	public Iterable<Image> findImageByBatchAndStatus(Long id, String status){
		Batch batch = batchRepository.findOne(id);
		return imageRepository.findByBatchAndStatus(batch, status);
	}
	
	public Image save(Image image){
		return imageRepository.save(image);
	}
	
}
