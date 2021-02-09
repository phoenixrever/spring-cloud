package com.phoenixhell.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import sun.applet.Main;

@SpringBootApplication
@EnableHystrixDashboard
public class MainHystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(MainHystrixDashboard9001.class, args);
    }
}
