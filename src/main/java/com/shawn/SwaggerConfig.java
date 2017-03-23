package com.shawn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author sofien
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("restful-api")
        .select()
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo(
        "MY APP", 
        "Generated API Doc.", 
        "MY API",
        "Terms of service URL", 
        "sofien.hamdi@gmail.com", 
        "All right reserved to MY COMPANY" , 
        "MY COMPANY URL");
    return apiInfo;
  }
}
