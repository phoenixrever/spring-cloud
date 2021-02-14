package com.spring.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//open-fegin 的自带fallback并不需要下面2个注解
@EnableHystrix
@EnableCircuitBreaker
public class MainHystrixFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MainHystrixFeignOrder80.class, args);
    }
}
