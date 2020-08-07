package com.alone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption Payment8006Application
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8006Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8006Application.class, args);
    }
}
