package com.app.index.service.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "index-login-logging-queue")
public class Receiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println(message);
    }

}
