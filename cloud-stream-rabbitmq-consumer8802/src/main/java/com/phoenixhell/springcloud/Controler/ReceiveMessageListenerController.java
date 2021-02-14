package com.phoenixhell.springcloud.Controler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    //注意没有任何mapping路由
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        String s = message.getPayload() + "\t server port:" + serverPort;
        System.out.println(s);
    }
}
