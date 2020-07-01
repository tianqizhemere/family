package top.tianqi;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
@MapperScan(basePackages = {"top.tianqi.turntable.dao"})
public class TurntableApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurntableApplication.class, args);
    }

}
