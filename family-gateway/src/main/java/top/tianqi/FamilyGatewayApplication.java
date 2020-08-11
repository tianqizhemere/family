package top.tianqi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

/**
 * @Author wkh
 * @Date 2020/6/30 16:06
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class FamilyGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyGatewayApplication.class, args);
    }

//    /** 异常处理器 */
//    @Bean
//    public GlobalExceptionHandler globalExceptionHandler() {
//        return new GlobalExceptionHandler();
//    }

    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return ServerCodecConfigurer.create();
    }

}
