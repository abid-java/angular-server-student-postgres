package com.app.samples.springboot;

import java.util.Collections;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudexampleAngularServerStudentApplication.
 */
@SpringBootApplication
@EnableSwagger2
public class CrudexampleAngularServerStudentApplication {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(CrudexampleAngularServerStudentApplication.class.getName());

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		logger.info("<<<<<====================================== Executing Spring Boot Application ======================================>>>>>");
		SpringApplication.run(CrudexampleAngularServerStudentApplication.class, args);
	}
	
	/**
	 * Swagger configuration.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
						.select()
						.paths(PathSelectors.ant("/students/*"))
						.apis(RequestHandlerSelectors.basePackage("com.app.samples.springboot"))
						.build()
						.apiInfo(apiInfo());
	}
	
	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("STUDENT API", 
						   "Sample API for Student Information",
						   "1.0",
						   "Free to Use",
						   new Contact("Abid Mohd", "https://github.com/abid-java", "mohd.92java@gmail.com"),
						   "API License",
						   "https://github.com/abid-java",
						   Collections.emptyList());
	}

}
