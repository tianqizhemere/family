package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * swagger配置类
 * @Author Wukh
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.turntable.turntable.*"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("family")	//标题
                .description("Restful-API-Doc")	//描述
                .termsOfServiceUrl("https://www.tianqizhemere.top") //
                .contact(new Contact("天气这么热", "https://www.tianqizhemere.top", "incluse6715@163.com")) // 三个参数依次是姓名，个人网站，邮箱
                .version("1.0") //版本
                .build();
    }
}
