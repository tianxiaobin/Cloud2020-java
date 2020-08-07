package com.alone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption Order8014Application
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class Order8014Application {
    public static void main(String[] args) {
        SpringApplication.run(Order8014Application.class, args);
    }
}
