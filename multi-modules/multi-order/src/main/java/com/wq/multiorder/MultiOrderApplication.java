package com.wq.multiorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MultiOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiOrderApplication.class, args);
    }

}
