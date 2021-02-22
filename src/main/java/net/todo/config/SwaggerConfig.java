package net.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.todo"))
                .paths(PathSelectors.ant("/v2/todo/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Spring boot with RESTFul web service Demo Application",
                "This application demonstrates documenting os Spring Boot app with Swagger using SpringFox.",
                "1.0.0",
                "TERMS OF SERVICE URL",
                new Contact("Patrick Nshizirungu", "http://www.todo.com", "pmpumuropizzou@gmail.com"),
                " License",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

}

	/*
	 * Contact contact = new Contact("TODO", "http://www.todo.com", "todo@info.com"
	 * 
	 * );
	 * 
	 * List<VendorExtension> vendorExtensions = new ArrayList<>();
	 * 
	 * ApiInfo apiInfo = new ApiInfo("TODO App RESTful web service documentation",
	 * 
	 * "This pages  documents TODO App RESTful web service endpoints", "1.0",
	 * "http://www.todo.com/service.html", contact, "Apache 2.0",
	 * "http://www.apache.org/licenses/LICENSE-2.0", vendorExtensions);
	 * 
	 * @Bean public Docket apiDocket() {
	 * 
	 * Docket docket = new Docket(DocumentationType.SWAGGER_2)
	 * 
	 * .apiInfo(apiInfo).select().apis(RequestHandlerSelectors.basePackage(
	 * "net.todo")) .paths(PathSelectors.any()).build();
	 * 
	 * return docket; }
	 */

