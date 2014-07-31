package com.reverend.imagePreProcess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reverend.imagePreProcess.model.Project;
import com.reverend.imagePreProcess.service.ProjectService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView home(){
		Iterable<Project> projects = projectService.findAll();
		return new ModelAndView("index", "projects", projects);
	}

}
