package top.tianqi;

import exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author wkh
 * @Date 2020/6/30 16:06
 */
@SpringBootApplication
public class FamilyGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyGatewayApplication.class, args);
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
