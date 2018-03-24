package org.spring.data.jpa.test.controller;

import org.apache.commons.lang3.StringUtils;
import org.spring.data.jpa.test.dao.UserRepository;
import org.spring.data.jpa.test.entity.User;
import org.spring.data.jpa.test.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/v1/user")
    public List<User> findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return userRepository.findAll(pageable).getContent();
    }

    @GetMapping("/api/v1/user/byUserName")
    public List<User> findByUserName(@RequestParam String userName, @RequestParam(required = false) Integer page,
                                     @RequestParam(required = false) Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("userName can not null or empty or blank");
        }
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> users = userRepository.findByUserName(userName, pageable);
        return users.getContent();
    }

    @PutMapping("/api/v1/user")
    public void modifyUserNameByUserId(@RequestParam String userName, @RequestParam UserType userType, @RequestParam Long id, HttpServletResponse response) {
        userRepository.modifyUserNameByUserId(userName, userType, id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
