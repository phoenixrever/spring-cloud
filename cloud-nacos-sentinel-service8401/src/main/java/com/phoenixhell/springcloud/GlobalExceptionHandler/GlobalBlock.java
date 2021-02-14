package com.phoenixhell.springcloud.GlobalExceptionHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.phoenixhell.springcloud.entities.CommonResult;
import com.phoenixhell.springcloud.entities.Payment;

public class GlobalBlock {
    public static CommonResult globalHandler1(BlockException exception) {
        return new CommonResult(4444,"custom globalBlock 1",new Payment(2020L,"serial002"));
    }

    public static CommonResult globalHandler2(BlockException exception) {
        return new CommonResult(4444, "custom globalBlock 2", new Payment(2020L, "serial002"));
    }
}
