package com.phoenixhell.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 说明1.0.0以后不允许手动创建数据源代理 只要创建数据源bean即可
 */
@Configuration
public class SeataDataSourceProxyConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource(){
        return  new DruidDataSource();
    }
}
