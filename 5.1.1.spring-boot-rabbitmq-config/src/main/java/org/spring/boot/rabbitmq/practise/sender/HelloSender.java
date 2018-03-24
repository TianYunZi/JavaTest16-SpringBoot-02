package org.spring.boot.rabbitmq.practise.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        for (int i = 0; i < 100; i++) {
            String context = "hello " + new Date();
            System.out.println("Sender : " + context);
            this.rabbitTemplate.convertAndSend("hello", context + " " + i);
        }
    }
}
