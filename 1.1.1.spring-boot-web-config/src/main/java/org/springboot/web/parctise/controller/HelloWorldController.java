package org.springboot.web.parctise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/api/v1/hello")
    public String hello() {
        return "Hello, world" + 1;
    }

    @GetMapping("/api/v1/exception")
    public Integer exception() {
        return 1 / 0;
    }
}
