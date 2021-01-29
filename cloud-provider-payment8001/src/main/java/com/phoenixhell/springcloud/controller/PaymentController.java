package com.phoenixhell.springcloud.controller;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.discovery.shared.Applications;
import com.phoenixhell.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.entities.Payment;
import com.phoenixhell.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

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

    //从Eureka服务拿到的自己在上面的注册信息
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult<>(200, "get ok ------port:"+serverPort,payment);
        }else{
            return new CommonResult<>(404, "get fail ------port:"+serverPort,null);
        }
    }

    @GetMapping("/discover")
    public Map<String, Object> discover(){
        HashMap<String, Object> map = new HashMap<>();
        String description = discoveryClient.description();
        map.put("description",description);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        map.put("instances",instances);
        int order = discoveryClient.getOrder();
        map.put("order",order);
        List<String> services = discoveryClient.getServices();
        map.put("services",services);
        Class<? extends DiscoveryClient> aClass = discoveryClient.getClass();
        map.put("aClass",aClass);
        String s = discoveryClient.toString();
        map.put("s ",s );
        return map;
    }
}
