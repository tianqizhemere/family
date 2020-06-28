package com.turntable;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import exception.GlobalExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// @EnableEurekaClient
@EnableEncryptableProperties
@MapperScan(basePackages = {"com.turntable.turntable.dao"})
@EnableSwagger2
public class TurntableApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurntableApplication.class, args);
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}
