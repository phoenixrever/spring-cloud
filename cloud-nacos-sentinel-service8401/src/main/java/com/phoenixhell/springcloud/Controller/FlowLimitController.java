package com.phoenixhell.springcloud.Controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"-----------");
        return "------testB";
    }
    @GetMapping("/testC")
    public String testC()
    {
        log.info("testC异常比例");
        int age=10/0;
        return "------testC";
    }
    @GetMapping("/testD")
    public String testD()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");

        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 异常数");
        try {
            int age=10/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "------testE";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return  "testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException be){
        return "I'm fallBackHandler"+be.getMessage();
    }
}
