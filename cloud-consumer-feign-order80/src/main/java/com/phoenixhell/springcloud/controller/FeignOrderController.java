package com.phoenixhell.springcloud.controller;

import com.phoenixhell.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.entities.Payment;
import com.phoenixhell.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author phoenixhell
 * @create 2021/1/31 0031-下午 12:25
 */
@RestController
public class FeignOrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/feign/payment/{id}")
    public CommonResult<Payment> getFeignPaymentById(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/feign/payment/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }
}
