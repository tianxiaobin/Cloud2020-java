package com.alone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author alone
 * @date 2020/6/30
 * @desciption Eureka7003Application
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7003Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7003Application.class, args);
    }
}