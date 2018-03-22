package org.spring.boot.redis.session.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.swagger.basic.system.SystemPropertySetter;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SystemPropertySetter.setNetworkInterfaceSelectionProperties();
        SpringApplication.run(RedisApplication.class, args);
    }
}
