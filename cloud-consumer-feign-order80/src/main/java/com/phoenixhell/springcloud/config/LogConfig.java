package com.phoenixhell.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author phoenixhell
 * @create 2021/1/31 0031-下午 1:27
 */
@Configuration
public class LogConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
