package com.baizhi.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class ListenerConsumer {
    @JmsListener(destination = "tcsTestP2P")
    public void consumer(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        System.out.println(textMessage.getText());
    }
}
