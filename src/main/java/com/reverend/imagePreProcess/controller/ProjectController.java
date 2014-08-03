package com.reverend.imagePreProcess.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.reverend.imagePreProcess.model.Project;
import com.reverend.imagePreProcess.service.AttributeTypeService;
import com.reverend.imagePreProcess.service.ProjectService;
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
	private ProjectService projectService;
	@Autowired
	private AttributeTypeService attributeTypeService;
	
	@Autowired
	private ProjectUtil projectUtil;
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@RequestParam("path") String path, @RequestParam("preProcessor") String preProcessor, @RequestParam("supervisor") String supervisor){
		Project project = projectUtil.createProject(path, preProcessor, supervisor);
		projectService.save(project);
		return "redirect:/project/view/"+project.getId();
	}
	
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public ModelAndView view(@PathVariable long id){
		Project project = projectService.find(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("project", project);
		map.put("attributeTypes", attributeTypeService.findAllAttributeTypes());
		return new ModelAndView("project/view", map);
	}
	
	@RequestMapping("/list")
	public ModelAndView list(){
		Iterable<Project> projects = projectService.findAll();
		return new ModelAndView("project/list", "projects", projects);
	}

}
