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


//有了feign 就不需要这个负载均衡了 feign自带
//赋予restTemplate开服务端口启负载均衡 端口交替出现
    //开启了自定义算法就不起作用
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
