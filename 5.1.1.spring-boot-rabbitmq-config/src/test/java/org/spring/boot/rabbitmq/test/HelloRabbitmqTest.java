package org.spring.boot.rabbitmq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.boot.rabbitmq.practise.RabbitmqApplication;
import org.spring.boot.rabbitmq.practise.sender.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRabbitmqTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() {
        helloSender.send();
    }
}
