package com.reverend.imagePreProcess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reverend.imagePreProcess.dao.ProjectRepository;
import com.reverend.imagePreProcess.model.Project;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;	
	
	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}
	
	public Project save(Project project){
		return projectRepository.save(project);
	}
	
	public Project find(Long id){
		return projectRepository.findOne(id);
	}

	
	public Iterable<Project> findAll(){
		return projectRepository.findAll();
	}
	

}
