package sanrockzz.gradledemo.config;

import org.springframework.context.annotation.Configuration;

/**
 * Swagger Config
 *
 * @author : Sanjeev Saxena
 * @Date : Jan 14, 2018
 * @since : 1.0
 */

@Configuration
public class SwaggerConfig {

/**
 @Bean public Docket apiDocket() {
 return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
 .paths(PathSelectors.any()).build();
 }

 @SuppressWarnings("unchecked") private ApiInfo apiInfo() {
 return new ApiInfo("Tagging Service APIs", "Service to list all tagging related APIs", "1.0", "",
 new Contact("Sanrockzz", "https://www.linkedin.com/in/sanjeevkumar-saxena-84421b45/",
 "sanrocks123@gmail.com"),
 "Copyrights (c), 2019. Sanrockzz Ltd. All Rights Reserved", "https://github.com/sanrocks123",
 Collections.EMPTY_LIST);
 }
 */
}