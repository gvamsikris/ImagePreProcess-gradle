package com.reverend.imagePreProcess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author vgajula
 *
 */

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@RequestParam("path") String path){
		System.out.println("path " + path);
		return "";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String view(){
		return "";
	}

}
