package top.tianqi;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import exception.GlobalExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @EnableEurekaClient
@EnableEncryptableProperties
@MapperScan(basePackages = {"top.tianqi.turntable.dao"})
public class TurntableApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurntableApplication.class, args);
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}
