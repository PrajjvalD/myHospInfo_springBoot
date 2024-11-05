package com.myhospinfos.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

	// private static final String BEARER_AUTH = "Bearer";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.javainuse.controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("AEMS REST API").description("\"AEMS\"").version("1.0.0")
				.license("BAHWAN CYBERTEK PVT LTD")
				// .contact(new Contact("BCT Support", "SHI_Support@bahwancybertek.com",
				// "SHI_Support@bahwancybertek.com"))

				// .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				// .contact(new Contact("John Thompson", "https://springframework.guru/about/",
				// "john@springfrmework.guru"))
				.build();
	}

	/*
	 * private List<SecurityReference> defaultAuth() { AuthorizationScope
	 * authorizationScope = new AuthorizationScope("global", "accessEverything");
	 * AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	 * authorizationScopes[0] = authorizationScope; return Arrays.asList(new
	 * SecurityReference("apiKey", authorizationScopes)); }
	 */

	/*
	 * private List<SecurityScheme> securitySchemes() { return Arrays.asList(new
	 * ApiKey(BEARER_AUTH, "Authorization", "header")); }
	 */

	/*
	 * private SecurityContext securityContext() { return
	 * SecurityContext.builder().securityReferences(Arrays.asList(
	 * bearerAuthReference())).forPaths(PathSelectors.ant("/fileservice/**")).build(
	 * ); }
	 */

	/*
	 * private SecurityReference basicAuthReference() { return new
	 * SecurityReference(BASIC_AUTH, new AuthorizationScope[0]); }
	 */
	/*
	 * private SecurityReference bearerAuthReference() { return new
	 * SecurityReference(BEARER_AUTH, new AuthorizationScope[0]); }
	 */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/api/swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
		registry.addResourceHandler("/api/webjars").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}