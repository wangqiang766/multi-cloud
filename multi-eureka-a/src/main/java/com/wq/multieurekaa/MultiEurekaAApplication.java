package com.wq.multieurekaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MultiEurekaAApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiEurekaAApplication.class, args);
    }

}
