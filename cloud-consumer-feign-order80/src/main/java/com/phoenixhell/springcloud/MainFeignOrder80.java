package com.phoenixhell.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author phoenixhell
 * @create 2021/1/31 0031-下午 12:13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MainFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MainFeignOrder80.class,args);
    }
}
