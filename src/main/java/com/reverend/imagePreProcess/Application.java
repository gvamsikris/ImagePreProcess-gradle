package com.reverend.imagePreProcess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reverend.imagePreProcess.dao.AttributeHome;
import com.reverend.imagePreProcess.dao.AttributeTypeHome;
import com.reverend.imagePreProcess.dao.AttributeValueHome;
import com.reverend.imagePreProcess.dao.BatchHome;
import com.reverend.imagePreProcess.dao.ImageHome;
import com.reverend.imagePreProcess.dao.ProjectHome;
import com.reverend.imagePreProcess.util.ProjectUtil;

@Configuration
@ComponentScan(basePackages={"com.reverend.imagePreProcess.dao", "com.reverend.imagePreProcess.util", "com.reverend.imagePreProcess.service", "com.reverend.imagePreProcess.controller"})
@EnableAutoConfiguration
@Controller
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ProjectUtil getProjectUtil(){
		return new ProjectUtil();
	}
	
	@Bean
	public ProjectHome getProjectHome(){
		return new ProjectHome();
	}
	
	@Bean
	public BatchHome getBatchHome(){
		return new BatchHome();
	}
	
	@Bean
	public ImageHome getImageHome(){
		return new ImageHome();
	}
	
	@Bean
	public AttributeHome getAttributeHome(){
		return new AttributeHome();
	}
	
	@Bean
	public AttributeTypeHome getAttributeTypeHome(){
		return new AttributeTypeHome();
	}
	
	@Bean
	public AttributeValueHome getAttributeValueHome(){
		return new AttributeValueHome();
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
