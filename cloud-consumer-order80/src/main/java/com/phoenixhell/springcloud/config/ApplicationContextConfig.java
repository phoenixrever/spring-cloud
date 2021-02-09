package com.phoenixhell.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 10:47
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced  //赋予restTemplate开服务端口启负载均衡 端口交替出现
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
