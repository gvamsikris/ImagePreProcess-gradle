package com.reverend.imagePreProcess.util;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.springframework.stereotype.Component;

import com.reverend.imagePreProcess.model.Batch;
import com.reverend.imagePreProcess.model.Project;

@Component
public class ProjectUtil {

	public Project createProject(String path, String preProcessor, String supervisor) {
		Project project = new Project();
		project.setDateCreated(new Date());
		project.setLastUpdated(new Date());
		project.setPath(path);
		project.setPreProcessor(preProcessor);
		project.setSupervisor(supervisor);
		File projectFolder = new File(path);
		Set<Batch> batchs = new HashSet<Batch>(0);
		if (projectFolder.isDirectory()) {
			String[] subFolderList = projectFolder.list(DirectoryFileFilter.DIRECTORY);
			for (int i = 0; i < subFolderList.length; i++) {
				String subPath = subFolderList[i];
				Batch batch = new Batch(project, new Date(), new Date(), subPath);
				batchs.add(batch);
			}
		}
		project.setBatchs(batchs);
		return project;
	}

}
