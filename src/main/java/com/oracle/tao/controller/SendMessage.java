package com.oracle.tao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessage {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping("/send")
    public String getConfigInfo(){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("test2", "{id:123}");

        future.addCallback(success -> System.out.println("KafkaMessageProducer 发送消息成功！"),
                fail -> System.out.println("KafkaMessageProducer 发送消息失败！"));

        return "ok";
    }
}


