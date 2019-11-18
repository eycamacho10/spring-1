package com.globant.spring.d.singleton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonTest {

    private SingletonBean singletonBean;
    private ApplicationContext ctx;

    @Before
    public void init() {
        System.setProperty("spring.profiles.active", "test");
        this.ctx = new ClassPathXmlApplicationContext("spring-test-config.xml");
    }

    @Test
    public void testLazyInitBeanProcess() {
        singletonBean = (SingletonBean) ctx.getBean("singletonBean");
        String res = singletonBean.process();
        Assert.assertEquals("singleton bean", res);
    }
}
