package com.phoenixhell.springcloud;

import com.phoenixhell.springcloud.Service.FeignOrderService;
import com.phoenixhell.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

//这个注解不能少
@Service
public class GlobalFallbackHandlerService implements FeignOrderService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(88888, "this is a fall back service message",new Payment(10L,"1111"));
    }
}


