package com.phoenixhell.springcloud.controller;

import com.phoenixhell.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.entities.Payment;
import com.phoenixhell.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 8:58
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired //@Resource
    //接口调用就行 不用实体类
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create/{serial}")
    public CommonResult<Payment> create(@PathVariable("serial")String serial){
        Payment payment = new Payment(null, serial);
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult<>(200, "create ok ------port:"+serverPort, payment);
        }else{
            return new CommonResult<>(404, "create fail ------port:"+serverPort,null);

        }
    }


    @PostMapping(value = "/payment/create")
    //resTemplate 传来的数据是josn格式要用@RequestBody
    public CommonResult<Payment> create(@RequestBody Payment payment){
        log.error(payment.toString()+"-------------");
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult<>(200, "create ok ------port:"+serverPort, payment);
        }else{
            return new CommonResult<>(404, "create fail ------port:"+serverPort,null);

        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult<>(200, "get ok ------port:"+serverPort,payment);
        }else{
            return new CommonResult<>(404, "get fail ------port:"+serverPort,null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("payment/zipkin")
    public String paymentZipKin(){
        return serverPort+"hi this is a zipkin server test　よろしくお願いします！";
    }
}
