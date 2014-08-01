package com.reverend.imagePreProcess.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reverend.imagePreProcess.model.Attribute;
import com.reverend.imagePreProcess.model.AttributeType;
import com.reverend.imagePreProcess.model.Batch;
import com.reverend.imagePreProcess.model.Image;
import com.reverend.imagePreProcess.model.Project;
import com.reverend.imagePreProcess.service.AttributeTypeService;

@Component
public class ProjectUtil {

	private static final String IMAGES = "images";
	private final List<String> extList = new ArrayList<String>(Arrays.asList(".jpg", ".bmp"));
	
	@Autowired
	private AttributeTypeService attributeTypeService;

	public Project createProject(String path, String preProcessor, String supervisor) {
		Project project = new Project();
		project.setDateCreated(new Date());
		project.setLastUpdated(new Date());
		project.setPath(path);
		project.setPreProcessor(preProcessor);
		project.setSupervisor(supervisor);
		File projectFolder = new File(path);
		createBatches(project, projectFolder);
		return project;
	}

	private void createBatches(Project project, File projectFolder) {
		List<Batch> batchs = new ArrayList<Batch>();
		if (projectFolder.isDirectory()) {
			String[] subFolderList = projectFolder.list(DirectoryFileFilter.DIRECTORY);
			for (int i = 0; i < subFolderList.length; i++) {
				String subPath = subFolderList[i];
				Batch batch = new Batch(project, new Date(), new Date(), subPath);
				createImages(batch, projectFolder);
				batchs.add(batch);
			}
		}
		project.setBatchs(batchs);
	}

	private void createImages(Batch batch, File projectFolder) {
		Set<Image> images = new HashSet<Image>(0);
		String imagePath = projectFolder.getAbsolutePath() + File.separator + batch.getPath() + File.separator + IMAGES;
		File imageFolder = new File(imagePath);
		FileFilter filter = new SuffixFileFilter(extList, IOCase.INSENSITIVE);
		File[] files = imageFolder.listFiles(filter);
		for (File file : files) {
			Image image = new Image(batch, new Date(), new Date(), file.getName());
			System.out.println(file.getName() + "-----------" + file.getAbsolutePath());
			populateAttributes(image);
			images.add(image);
		}
		
		batch.setImages(images);
	}

	private void populateAttributes(Image image) {
		Iterable<AttributeType> allAttributeTypes = attributeTypeService.findAllAttributeTypes();
		for (AttributeType attributeType : allAttributeTypes) {
			image.getAttributes().add(new Attribute(attributeType, image, new Date(), new Date(), ""));
		}
	}

}
