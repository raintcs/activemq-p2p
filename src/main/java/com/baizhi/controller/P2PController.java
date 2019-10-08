package com.baizhi.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RestController
@RequestMapping("/p2p")
public class P2PController {
    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping("/send")
    public String send() {
        Destination destination = new ActiveMQQueue("tcsTestP2P");
        jmsTemplate.convertAndSend(destination, "点对点");
        return "消息发送成功";
    }
}
