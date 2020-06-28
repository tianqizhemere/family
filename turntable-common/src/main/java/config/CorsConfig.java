package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 跨域支持
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 代表可以被访问的接口
        registry.addMapping("/**")
                // 代表将要访问后端的前端地址
                .allowedOrigins("*")
                // 是否允许浏览器中cookie等进行跨域
                .allowCredentials(true)
                // 代表有哪些头信息可以跨域
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 跨域允许时间
                .maxAge(3600);
    }
}
