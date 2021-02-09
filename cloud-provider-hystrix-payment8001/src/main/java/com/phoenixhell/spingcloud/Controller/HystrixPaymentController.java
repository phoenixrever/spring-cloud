package com.phoenixhell.spingcloud.Controller;

import com.phoenixhell.spingcloud.service.HystrixPaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author phoenixhell
 * @create 2021/1/31 0031-下午 3:01
 */
@RestController
public class HystrixPaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private HystrixPaymentService hystrixPaymentService;

    @GetMapping("/hystrix/payment/ok/{id}")
    public String getHystrixPaymentOK(@PathVariable("id")Integer id){
        String s = hystrixPaymentService.PaymentInfo_OK(id);
        return "端口:"+serverPort+"----"+s;
    }
    @GetMapping("/hystrix/payment/timeout/{id}")
    public String getHystrixPaymentTimeOut(@PathVariable("id")Integer id){
        String s = hystrixPaymentService.PaymentInfo_Timeout(id);
        return "端口:"+serverPort+"----"+s;
    }

    @GetMapping("/hystrix/payment/circuit-breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return hystrixPaymentService.paymentCircuitBreaker(id);
    }
}
