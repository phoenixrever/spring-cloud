package com.phoenixhell.springcloud.controller;

import com.phoenixhell.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.entities.Payment;
import com.phoenixhell.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/payment/create/{serial}")
    public CommonResult<Payment> create(@PathVariable("serial")String serial){
        Payment payment = new Payment(null, serial);
        int result = paymentService.create(payment);
        log.error("插入结果"+result);
        if(result>0){
            return new CommonResult<>(200, "create ok", payment);
        }else{
            return new CommonResult<>(404, "create fail",null);

        }
    }


    @PostMapping(value = "/payment/create")
    //resTemplate 传来的数据是josn格式要用@RequestBody
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.error("插入结果"+result);
        if(result>0){
            return new CommonResult<>(200, "create ok", payment);
        }else{
            return new CommonResult<>(404, "create fail",null);

        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.error("查询结果"+payment);
        if(payment!=null){
            return new CommonResult<>(200, "get ok",payment);
        }else{
            return new CommonResult<>(404, "get fail",null);
        }
    }
}
