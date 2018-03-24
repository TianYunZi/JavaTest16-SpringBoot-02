package org.spring.boot.rabbitmq.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReceiverRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceiverRabbitmqApplication.class, args);
    }
}
