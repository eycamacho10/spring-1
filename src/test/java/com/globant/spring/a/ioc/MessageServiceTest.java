package com.globant.spring.a.ioc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageServiceTest {

    private MessageService messageService;

    @Before
    public void init() {
        System.setProperty("spring.profiles.active", "test");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test-config.xml");
        messageService = (MessageService) ctx.getBean("messageService");
    }

    @Test
    public void testSendMessage() {
        String res = messageService.sendMessage("Message");
        Assert.assertEquals("The message was sent! Message", res);
    }
}
