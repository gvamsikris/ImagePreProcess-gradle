package com.reverend.imagePreProcess;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.reverend.imagePreProcess.model.Attribute;
import com.reverend.imagePreProcess.model.AttributeType;
import com.reverend.imagePreProcess.model.AttributeValue;
import com.reverend.imagePreProcess.model.Batch;
import com.reverend.imagePreProcess.model.Image;
import com.reverend.imagePreProcess.model.Project;

@Configuration
public class RespositoryConfig extends RepositoryRestMvcConfiguration {
	
	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		super.configureRepositoryRestConfiguration(config);
		config.exposeIdsFor(Image.class, Project.class, Batch.class, AttributeType.class, Attribute.class, AttributeValue.class);
	}
}
