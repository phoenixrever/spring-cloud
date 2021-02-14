package com.phoenixhell.springcloud.service.Impl;

import com.phoenixhell.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

//定义消息的推送管道 从stream发送消息就是输出source 接受就是输入sink
@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {
    @Resource
    //output名字只能是这个 why?
    private MessageChannel output;

    @Override
    public String send() {
      String serialId = UUID.randomUUID().toString().substring(0,6);
        boolean send = output.send(MessageBuilder.withPayload(serialId).build());
        System.out.println("******"+serialId);
        return send+"";
    }
}
