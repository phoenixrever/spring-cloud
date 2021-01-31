package com.phoenixhell.springcloud;

import com.phoenixhell.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 10:35
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name ="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class MainOrder80 {
    public static void main(String[] args) {
     SpringApplication.run(MainOrder80.class, args);
    }
}
