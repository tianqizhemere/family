package com.turntable;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
}
