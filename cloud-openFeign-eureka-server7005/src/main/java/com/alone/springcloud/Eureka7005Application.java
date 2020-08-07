package com.alone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author alone
 * @date 2020/6/30
 * @desciption Eureka7005Application
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7005Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7005Application.class, args);
    }
}