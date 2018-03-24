package org.spring.boot.rabbitmq.practise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.swagger.basic.system.SystemPropertySetter;

@SpringBootApplication
public class RabbitmqApplication {

    public static void main(String[] args) {
        SystemPropertySetter.setNetworkInterfaceSelectionProperties();
        SpringApplication.run(RabbitmqApplication.class, args);
    }
}
