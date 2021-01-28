package com.phoenixhell.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 10:35
 */
@SpringBootApplication
@EnableEurekaClient
public class MainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MainOrder80.class,args);
    }
}
