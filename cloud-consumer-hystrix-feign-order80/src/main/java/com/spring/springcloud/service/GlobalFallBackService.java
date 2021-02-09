package com.spring.springcloud.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GlobalFallBackService  implements PaymentHystrixFeignService {

    @Override
    public String getHystrixPaymentOK(Integer id) {
        return "全局方法报错或者服务器宕机";
    }

    @Override
    public String getHystrixPaymentTimeOut(Integer id) {
        return "全局方法延时或者报错";
    }
}
