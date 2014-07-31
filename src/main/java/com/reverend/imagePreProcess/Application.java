package com.reverend.imagePreProcess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reverend.imagePreProcess.util.ProjectUtil;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.reverend.imagePreProcess.dao", "com.reverend.imagePreProcess.util", "com.reverend.imagePreProcess.service", "com.reverend.imagePreProcess.controller"})
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ProjectUtil getProjectUtil(){
		return new ProjectUtil();
	}
}
