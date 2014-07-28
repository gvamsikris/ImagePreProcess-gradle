package com.reverend.imagePreProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.reverend.imagePreProcess.model.Project;
import com.reverend.imagePreProcess.service.ModelService;
import com.reverend.imagePreProcess.util.ProjectUtil;

/**
 * 
 * @author vgajula
 *
 */

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private ProjectUtil projectUtil;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView create(@RequestParam("path") String path){
		System.out.println("path " + path);
		projectUtil.setModelService(modelService);
		Project project = projectUtil.createProject(path);
		return new ModelAndView("project/view", "project", project);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView view(@PathVariable long id){
		Project project = modelService.getProjectHome().findById(id);
		return new ModelAndView("project/view", "project", project);
	}
	
	@RequestMapping("/list")
	public ModelAndView list(){
		List<Project> projects = modelService.getProjectHome().findAll();
		return new ModelAndView("project/list", "projects", projects);
	}

}
