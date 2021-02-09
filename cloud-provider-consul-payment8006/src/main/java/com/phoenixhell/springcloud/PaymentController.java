package com.phoenixhell.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul/payment")
    public String getConsul(){
        return "spring cloud with Consul---port"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
