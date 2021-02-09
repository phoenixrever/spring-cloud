package com.phoenixhell.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
