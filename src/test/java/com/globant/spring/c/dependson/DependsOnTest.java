package com.globant.spring.c.dependson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependsOnTest {

    private DependsOnBean dependsOnBean;

    @Before
    public void init() {
        System.setProperty("spring.profiles.active", "test");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test-config.xml");
        dependsOnBean = (DependsOnBean) ctx.getBean("dependsOnBean");
    }

    @Test
    public void testDependsOnProcess() {
        String res = dependsOnBean.process();
        Assert.assertEquals("message from DependsOnBean -> process", res);
    }
}
