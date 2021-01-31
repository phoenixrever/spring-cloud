package com.phoenixhell.spingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author phoenixhell
 * @create 2021/1/31 0031-下午 2:15
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class MainHystrixPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainHystrixPayment8001.class,args);
    }
}
