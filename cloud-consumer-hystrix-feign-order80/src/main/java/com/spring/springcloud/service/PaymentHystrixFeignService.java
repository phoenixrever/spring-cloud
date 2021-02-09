package com.spring.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = GlobalFallBackService.class)
public interface PaymentHystrixFeignService {

    @GetMapping("/hystrix/payment/ok/{id}")
    public String getHystrixPaymentOK(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/payment/timeout/{id}")
    public String getHystrixPaymentTimeOut(@PathVariable("id") Integer id);
}
