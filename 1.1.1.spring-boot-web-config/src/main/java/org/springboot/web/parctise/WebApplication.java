package org.springboot.web.parctise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.swagger.basic.system.SystemPropertySetter;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SystemPropertySetter.setNetworkInterfaceSelectionProperties();
        SpringApplication.run(WebApplication.class, args);
    }
}
