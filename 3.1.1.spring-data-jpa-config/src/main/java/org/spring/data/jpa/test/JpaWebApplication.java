package org.spring.data.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.swagger.basic.system.SystemPropertySetter;

@SpringBootApplication
public class JpaWebApplication {

    public static void main(String[] args) {
        SystemPropertySetter.setNetworkInterfaceSelectionProperties();
        SpringApplication.run(JpaWebApplication.class, args);
    }
}
