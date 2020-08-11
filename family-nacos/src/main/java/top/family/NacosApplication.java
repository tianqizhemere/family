package top.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * eureka服务端
 * @Author Wukh
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启Nacos服务发现
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }
}
