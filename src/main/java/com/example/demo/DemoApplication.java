package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }
   @Bean
   public Docket productApi() {
      return new Docket(DocumentationType.SWAGGER_2).select()
         .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")).build();
   }
}
