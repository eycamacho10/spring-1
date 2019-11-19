package com.globant.spring.d.prototype;

import com.globant.spring.d.singleton.SingletonBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrototypeTest {

    private SingletonBean singletonBean;
    private PrototypeBean prototypeBean;
    private ApplicationContext ctx;

    @Before
    public void init() {
        System.setProperty("spring.profiles.active", "test");
        this.ctx = new ClassPathXmlApplicationContext("spring-test-config.xml");
    }

    @Test
    public void testPrototypeBeanProcess() {
        singletonBean = (SingletonBean) ctx.getBean("singletonBean");
        prototypeBean = (PrototypeBean) ctx.getBean("prototypeBean");
        singletonBean.process();
        prototypeBean.process();

        String messageSingleton = singletonBean.getMessage();
        String messagePrototype = prototypeBean.getMessage();

        singletonBean = (SingletonBean) ctx.getBean("singletonBean");
        prototypeBean = (PrototypeBean) ctx.getBean("prototypeBean");

        String messageSingletonTwice = singletonBean.getMessage();
        String messagePrototypeTwice = prototypeBean.getMessage();

        Assert.assertEquals("using singleton scope, the message is held", messageSingleton);
        Assert.assertEquals("using prototype scope, the message is missed", messagePrototype);
        Assert.assertEquals("using singleton scope, the message is held", messageSingletonTwice);
        Assert.assertTrue(messagePrototypeTwice == null);
    }
}
