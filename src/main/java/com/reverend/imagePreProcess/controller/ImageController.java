package com.reverend.imagePreProcess.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reverend.imagePreProcess.model.Attribute;
import com.reverend.imagePreProcess.model.Image;
import com.reverend.imagePreProcess.service.ImageService;

@RestController
@RequestMapping(value="/image")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/byBatch/{id}", method=RequestMethod.GET)
	public Iterable<Image> findByBatch(@PathVariable Long id){
		return imageService.findImageByBatchAndStatus(id, Image.NEW);
	}
	
	@RequestMapping("/{id}")
	public Image find(@PathVariable Long id){
		Image image = imageService.findImage(id);
		return image;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Image save(HttpServletRequest request){
		String imageId = request.getParameter("imageId");
		Image image = imageService.findImage(Long.valueOf(imageId));
		Set<Attribute> attributes = image.getAttributes();
		for (Attribute attribute : attributes) {
			String value = request.getParameter("attributeType" +attribute.getAttributeType().getId());
			attribute.setValue(value);
		}
		image.setStatus(Image.SAVED);
		imageService.save(image);
		return image;
	}

}
