package com.phoenixhell.springcloud.Controller;

import com.phoenixhell.springcloud.bean.CommonResult;
import com.phoenixhell.springcloud.bean.SeataOrder;
import com.phoenixhell.springcloud.mapper.SeataOrderMapper;
import com.phoenixhell.springcloud.service.OrderService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(SeataOrder seataOrder){
        orderService.create(seataOrder);
        return new CommonResult(200,"订单创建成功");
    }
}
