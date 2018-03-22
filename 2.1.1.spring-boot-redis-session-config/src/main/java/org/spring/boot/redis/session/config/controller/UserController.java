package org.spring.boot.redis.session.config.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.redis.session.config.dao.UserRepository;
import org.spring.boot.redis.session.config.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/v1/user")
    @Cacheable(value = "user-key")
    public User getUser(){
        User user = userRepository.findByUserName("aa1");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
}
