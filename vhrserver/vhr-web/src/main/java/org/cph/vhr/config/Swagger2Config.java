package org.cph.vhr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.cph.vhr.web"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                    .description("接口文档的描述信息")
                    .title("项目接口文档")
                    .contact(new Contact("cph", "http://www.cph.org", "cph979@qq.com"))
                    .version("v1.0")
                    .build());
    }
}
