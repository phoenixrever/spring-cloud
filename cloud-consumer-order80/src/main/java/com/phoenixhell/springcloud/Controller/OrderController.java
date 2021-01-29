package com.phoenixhell.springcloud.Controller;

import com.phoenixhell.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 10:38
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

//    @GetMapping("consumer/payment/create/{serial}")
//    public CommonResult<Payment> create(@PathVariable("serial") String serial){
//        return restTemplate.postForObject(PAYMENT_URL + "/payment/create/"+serial, null, CommonResult.class);
//    }

    @GetMapping("consumer/payment/create")
    //自动封装参数为payment 属性要和name一一对应
    //GET请求中，因为没有HttpEntity，所以@RequestBody并不适用。
    //form-data、x-www-form-urlencoded：不可以用@RequestBody；可以用@RequestParam。
    // 这两种方式的时候没有json字符串部分。
    //application/json：json字符串部分可以用@RequestBody
    // url中的?后面参数可以用@RequestParam
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

    }
    @GetMapping("consumer/payment/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
    }
}
