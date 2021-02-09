package com.spring.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.springcloud.service.PaymentHystrixFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@DefaultProperties(defaultFallback = "globalFallBack",commandProperties = {
//        //3秒钟以内就是正常的业务逻辑
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2500")
//})
public class HystrixFeignOrderController {
    @Autowired
//    @Qualifier(value = "globalFallBackService")
    PaymentHystrixFeignService paymentHystrixFeignService;

    @GetMapping("/consumer/hystrix/feign/payment/ok/{id}")
    public String getHystrixFeignPaymentOK(@PathVariable("id")Integer id){
//        System.out.println(paymentHystrixFeignService);
        return paymentHystrixFeignService.getHystrixPaymentOK(id);
    }
    @GetMapping("/consumer/hystrix/feign/payment/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            //3秒钟以内就是正常的业务逻辑
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
//    @HystrixCommand
    public String getHystrixFeignPaymentTimeOut(@PathVariable("id")Integer id){
        return paymentHystrixFeignService.getHystrixPaymentTimeOut(id);
    }

    //重要 参数必须要和hystrixCommand标注的一样不然methodNotfound错误
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+" paymentInfo_TimeoutHandler"+"\t"+"客户端系统繁忙或者出错，请稍后再试";
    }

    public String globalFallBack(){
        return "global exception handler something is wrong";
    }
}
