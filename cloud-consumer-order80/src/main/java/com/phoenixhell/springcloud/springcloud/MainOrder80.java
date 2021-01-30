package com.phoenixhell.springcloud.springcloud;

import com.phoenixhell.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 10:35
 */
@SpringBootApplication
@EnableEurekaClient
public class MainOrder80 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainOrder80.class, args);
        MySelfRule bean = run.getBean(MySelfRule.class);
        System.out.println(bean);
    }
}
