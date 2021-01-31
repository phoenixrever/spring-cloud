package com.phoenixhell.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 10:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainZookeeperOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MainZookeeperOrder80.class,args);
    }
}
