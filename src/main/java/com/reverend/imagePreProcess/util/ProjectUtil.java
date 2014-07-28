package com.reverend.imagePreProcess.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.reverend.imagePreProcess.model.Batch;
import com.reverend.imagePreProcess.model.Project;

public class ProjectUtil {
	
	public static Project createProject(String path){
		Project project = new Project();
		project.setPath(path);
		File projectFolder = new File(path);
		Set<Batch> batchs = new HashSet<Batch>(0);
		if(projectFolder.isDirectory()){
		}
		return project;
	}

}
