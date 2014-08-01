package com.reverend.imagePreProcess.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reverend.imagePreProcess.dao.AttributeRepsoitory;
import com.reverend.imagePreProcess.dao.BatchRepository;
import com.reverend.imagePreProcess.dao.ImageRepository;
import com.reverend.imagePreProcess.dao.ProjectRepository;
import com.reverend.imagePreProcess.model.Attribute;
import com.reverend.imagePreProcess.model.Batch;
import com.reverend.imagePreProcess.model.Image;
import com.reverend.imagePreProcess.model.Project;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;
	private BatchRepository batchRepository;
	private ImageRepository imageRepository;
	private AttributeRepsoitory attributeRepository;
	
	@Autowired
	public ProjectService(ProjectRepository projectRepository, BatchRepository batchRepository, ImageRepository imageRepository, AttributeRepsoitory attributeRepsoitory) {
		super();
		this.projectRepository = projectRepository;
		this.batchRepository = batchRepository;
		this.imageRepository = imageRepository;
		attributeRepository = attributeRepsoitory;
	}
	
	@Transactional
	public Project save(Project project){
		project = projectRepository.save(project);
		return project;
	}
	
	public Project find(Long id){
		return projectRepository.findOne(id);
	}

	
	public Iterable<Project> findAll(){
		return projectRepository.findAll();
	}
	
	@Transactional
	public Batch save(Batch batch){
		batch = batchRepository.save(batch);
		return batch;
	}

	public Image save(Image image) {
		image = imageRepository.save(image);
		return image;
	}

	public Attribute save(Attribute attribute) {
		attribute = attributeRepository.save(attribute);
		return attribute;
	}
	

}
