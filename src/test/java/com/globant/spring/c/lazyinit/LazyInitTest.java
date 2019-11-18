package com.globant.spring.c.lazyinit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyInitTest {

    private LazyBean lazyBean;
    private ApplicationContext ctx;

    @Before
    public void init() {
        System.setProperty("spring.profiles.active", "test");
        this.ctx = new ClassPathXmlApplicationContext("spring-test-config.xml");
    }

    @Test
    public void testLazyInitBeanProcess() {
        lazyBean = (LazyBean) ctx.getBean("lazyBean");
        String res = lazyBean.process();
        Assert.assertEquals("message from LazyBean -> process", res);
    }
}
