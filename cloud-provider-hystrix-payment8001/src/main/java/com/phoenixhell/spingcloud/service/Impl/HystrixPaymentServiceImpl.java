package com.phoenixhell.spingcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.phoenixhell.spingcloud.service.HystrixPaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author phoenixhell
 * @create 2021/1/31 0031-下午 2:29
 */
@Service
public class HystrixPaymentServiceImpl implements HystrixPaymentService {

    @Override
    public String PaymentInfo_OK(Integer id) {
        return "线程池"+Thread.currentThread().getName()+"  PaymentInfo_OK,id: "+"\t"+"^_^";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            //3秒钟以内就是正常的业务逻辑
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String PaymentInfo_Timeout(Integer id) {
        int time = 2;
//        int n=10/0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"  PaymentInfo_timeout,id: "+"\t"+"😢 耗时"+time+"秒钟";

    }

    //重要 参数必须要和hystrixCommand标注的一样不然methodNotfound错误
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+" paymentInfo_TimeoutHandler"+"\t"+"系统繁忙，请稍后再试";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //时间范围
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //失败百分率达到多少后跳闸(此处为10次请求60%的失败即为6此失败后开启熔断)
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("id 不能小于0");
        }
        //中文的文档能不用就别用
        String serialId= IdUtil.simpleUUID();
//        String serialId= UUID.randomUUID().toString().replace("-","");
        return Thread.currentThread().getName()+"----"+"id:"+serialId;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "paymentCircuitBreaker_fallback id 不能为负数"+id;
    }
}
