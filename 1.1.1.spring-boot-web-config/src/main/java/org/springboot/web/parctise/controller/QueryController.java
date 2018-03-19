package org.springboot.web.parctise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.web.parctise.config.NeoProperties;
import org.springboot.web.parctise.dao.UserRepository;
import org.springboot.web.parctise.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    private NeoProperties neoProperties;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/v1/user")
    public User findByUserNameOrEmail(@RequestParam String userName, @RequestParam String email) {
        LOGGER.info("userName: {}, email: {}", userName, email);
        return userRepository.findByUserNameAndEmail("bb2", "bb@126.com");
    }

    @GetMapping("/api/v1/user/{id}")
    public User findById(@PathVariable Long id) {
        LOGGER.info("id: {}", id);
        LOGGER.info("customer properties title: {} and description: {}", neoProperties.getTitle(), neoProperties.getDescription());
        return userRepository.findById(id);
    }


}
