package org.spring.boot.redis.session.config.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class SessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/api/v1/uid")
    public String uid(HttpSession httpSession) {
        UUID uuid = (UUID) httpSession.getAttribute("uid3");
        if (uuid == null) {
            LOGGER.info("session缓存中没有uuid,需创建");
            uuid = UUID.randomUUID();
            httpSession.setAttribute("uid3", uuid);
        }
        return httpSession.getId();
    }
}
