package org.spring.boot.redis.session.config.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 7)//原SpringBoot的server.session.timeout属性不再生效
public class SessionConfig {
}
