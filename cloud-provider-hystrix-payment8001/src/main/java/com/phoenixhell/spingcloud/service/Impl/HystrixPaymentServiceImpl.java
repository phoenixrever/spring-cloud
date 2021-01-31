package com.phoenixhell.spingcloud.service.Impl;

import com.phoenixhell.spingcloud.service.HystrixPaymentService;
import org.springframework.stereotype.Service;

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
    public String PaymentInfo_Timeout(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"  PaymentInfo_timeout,id: "+"\t"+"😢 耗时"+time+"秒钟";

    }
}
