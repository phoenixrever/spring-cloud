package com.phoenixhell.springcloud.service;

import com.phoenixhell.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author phoenixhell
 * @create 2021/1/31 0031-下午 12:19
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //openfeign-ribbon 默认等待1秒钟 ymal里面设置时间
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
