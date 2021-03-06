package com.reminderer.remindererservices.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
//			return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//					.paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("(/actuator.*|/error)"))).build()
				.apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Rememberer Services REST API").description("Rememberer Services MVP REST API")
				.contact(new Contact("Ian Davidson", "github.com/iandavidson/Rememberer-Services", "ianmattdavidson@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("0.0.1")
				.build();
	}

}
