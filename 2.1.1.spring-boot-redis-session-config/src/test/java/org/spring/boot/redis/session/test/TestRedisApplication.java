package org.spring.boot.redis.session.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.redis.session.config.RedisApplication;
import org.spring.boot.redis.session.config.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRedisApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRedisApplication.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("com.neox", user);
        valueOperations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
        Boolean hasKey = redisTemplate.hasKey("com.neo.f");
        if (hasKey) {
            LOGGER.info("exists is true");
        } else {
            LOGGER.info("exists is false");
        }
    }
}
