package com.alone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption Payment8007Application
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8007Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8007Application.class, args);
    }
}
