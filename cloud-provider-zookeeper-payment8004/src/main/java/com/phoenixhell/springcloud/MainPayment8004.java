package com.phoenixhell.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author phoenixhell
 * @create 2021/1/30 0030-下午 12:40
 */
@SpringBootApplication
//该注解用于向使用consule或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class MainPayment8004 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayment8004.class,args);
    }
}
