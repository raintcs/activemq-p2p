package com.baizhi.controller;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@RestController
@RequestMapping("/pubsub")
public class PubSubController {
    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping("/send")
    public String send() {
        Destination destination = new ActiveMQTopic("Public&Subscribe");
        jmsTemplate.convertAndSend(destination, "这是发布订阅模式");
        return "send success";
    }

    @RequestMapping("/receive")
    public String receive() throws JMSException {
        Destination destination = new ActiveMQTopic("Public&Subscribe");
        TextMessage message = (TextMessage) jmsTemplate.receive(destination);
        return message.getText();
    }
}
