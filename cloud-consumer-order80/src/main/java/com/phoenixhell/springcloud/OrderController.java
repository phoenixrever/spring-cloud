package com.phoenixhell.springcloud;

import com.phoenixhell.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.entities.Payment;
import com.phoenixhell.springcloud.loadbalance.Impl.MyLB;
import com.phoenixhell.springcloud.loadbalance.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 10:38
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancer loadBalancer;
    @Resource
    private RestTemplate restTemplate;

//    @GetMapping("consumer/payment/create/{serial}")
//    public CommonResult<Payment> create(@PathVariable("serial") String serial){
//        return restTemplate.postForObject(PAYMENT_URL + "/payment/create/"+serial, null, CommonResult.class);
//    }

    @GetMapping("/consumer/payment/create")
    //自动封装参数为payment 属性要和name一一对应
    //GET请求中，因为没有HttpEntity，所以@RequestBody并不适用。
    //form-data、x-www-form-urlencoded：不可以用@RequestBody；可以用@RequestParam。
    // 这两种方式的时候没有json字符串部分。
    //application/json：json字符串部分可以用@RequestBody
    // url中的?后面参数可以用@RequestParam
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

    }

    @GetMapping("/consumer/paymentEntity/create")
//  modelanview cover自动提取body方法封装的数据到页面 不一样要返回  CommonResult类型
    public ResponseEntity<CommonResult> createByEntity(Payment payment){
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return commonResultResponseEntity;

    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/paymentEntity/{id}")
    public ResponseEntity<CommonResult> getEntityById(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        System.out.println(entity.toString());
        return entity;
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> serviceInstances =
                discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instances = loadBalancer.instances(serviceInstances);
        System.out.println("main-"+instances);
        return restTemplate.getForObject(instances.getUri()+"/payment/lb",String.class);
    }
}
