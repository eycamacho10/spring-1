package com.globant.spring.b.beanoverview;

import com.globant.spring.a.ioc.MessageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageServiceConstructorsTest {

    private MessageServiceWithConstructor messageServiceConstructorsTestFirst;
    private MessageServiceWithConstructor messageServiceConstructorsTestSecond;

    @Before
    public void init() {
        System.setProperty("spring.profiles.active", "test");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test-config.xml");
        messageServiceConstructorsTestFirst = (MessageServiceWithConstructor) ctx.getBean("messageServiceWithSimpleArg");
        messageServiceConstructorsTestSecond = (MessageServiceWithConstructor) ctx.getBean("messageServiceWithComplexArg");
    }

    @Test
    public void testSendMessageFirstConstructor() {
        String res = messageServiceConstructorsTestFirst.sendMessageUsingCompany("Message");
        Assert.assertEquals("Company: BeerThe message object was sent! using constructor IoCMessage", res);
    }

    @Test
    public void testSendMessageSecondConstructor() {
        String res = messageServiceConstructorsTestSecond.sendMessageUsingService("Message");
        Assert.assertEquals("Super message: The message was sent! Message", res);
    }
}
