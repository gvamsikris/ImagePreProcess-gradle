package com.reverend.imagePreProcess;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.reverend.imagePreProcess.model.AttributeType;
import com.reverend.imagePreProcess.model.AttributeValue;
import com.reverend.imagePreProcess.service.AttributeTypeService;

@Configuration
@EnableTransactionManagement
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		ConfigurableApplicationContext applicationContext = application.run(args);
		bootstrap(applicationContext);
	}

	private static void bootstrap(ConfigurableApplicationContext applicationContext) {
		AttributeTypeService attributeTypeService = applicationContext.getBean(AttributeTypeService.class);
		Iterable<AttributeType> attributeTypes = attributeTypeService.findAllAttributeTypes();
		if (!attributeTypes.iterator().hasNext()) {
			
			AttributeType imageComplexity = createAttributeType("Image Complexity", "Very High", "High", "Medium", "Low", "Very Low");
			attributeTypeService.save(imageComplexity);
			
			AttributeType documentType = createAttributeType("Document Type", "baptism", "burial", "marriage", "Mixed", "list", "Passenger list", "register", "card", "other");
			attributeTypeService.save(documentType);

			AttributeType workType = createAttributeType("Work Type", "Paragraph", "Register", "List", "One-One", "Mortage", "other");
			attributeTypeService.save(workType);

			AttributeType numberOfFields = createAttributeType("Number of fields");
			attributeTypeService.save(numberOfFields);


			AttributeType language = createAttributeType("Language", "English", "Latin", "Spanish", "Danish", "German", "Portugese", "other");
			attributeTypeService.save(language);

			AttributeType matchingCI = createAttributeType("Matching CI", "Yes", "No");
			attributeTypeService.save(matchingCI);

			AttributeType comments = createAttributeType("Comments / Notes");
			attributeTypeService.save(comments);
		}
	}

	public static AttributeType createAttributeType(String name, String... values) {
		AttributeType attributeType = new AttributeType(new Date(), new Date(), name);
		for (String string : values) {
			attributeType.getAttributeValues().add(new AttributeValue(attributeType, new Date(), new Date(), string));
		}
		return attributeType;
	}
}
