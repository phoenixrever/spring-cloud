package com.phoenixhell.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 9:05
 */
@SpringBootApplication
@EnableEurekaClient
public class MainPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayment8001.class,args);
    }
}
