package com.spring.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosSentinelPayment9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosSentinelPayment9003.class, args);
    }
}
