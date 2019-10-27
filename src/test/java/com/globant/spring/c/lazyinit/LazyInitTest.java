package com.globant.spring.c.lazyinit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyInitTest {

    private LazyBean lazyBean;
    private NoLazyBean noLazyBean;
    private ApplicationContext ctx;

    @Before
    public void init() {
        System.setProperty("spring.profiles.active", "test");
        this.ctx = new ClassPathXmlApplicationContext("spring-test-config.xml");
        noLazyBean = (NoLazyBean) ctx.getBean("noLazyBean");
    }

    @Test
    public void testLazyInitBeanProcess() {
        String res = noLazyBean.process();
        Assert.assertEquals("message from NoLazyBean -> process", res);
        lazyBean = (LazyBean) ctx.getBean("lazyBean");
        res = lazyBean.process();
        Assert.assertEquals("message from LazyBean -> process", res);
    }
}
