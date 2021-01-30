package com.phoenixhell.springcloud.springcloud.Controller;

import com.phoenixhell.springcloud.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 10:38
 */
@RestController
@Slf4j
public class ConsulOrderController {
    public static final String PAYMENT_URL="http://cloud-consul-payment";
    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consul/order")
    public String geInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/consul/payment",String.class);
    }

}
