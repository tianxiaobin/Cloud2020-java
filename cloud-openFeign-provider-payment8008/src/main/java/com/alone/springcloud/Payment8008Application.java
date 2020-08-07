package com.alone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption Payment8008Application
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Payment8008Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8008Application.class, args);
    }
}
