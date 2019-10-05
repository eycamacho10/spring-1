package com.globant.spring.b.beanoverview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExampleBeanTest {

    private ExampleBean exampleBean;

    @Before
    public void init() {
        System.setProperty("spring.profiles.active", "test");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test-config.xml");
        exampleBean = (ExampleBean) ctx.getBean("exampleBean");
    }

    @Test
    public void testSetterInjection() {
        Assert.assertEquals("ExampleBean{beanOne=AnotherBean{}, beanTwo=YetAnotherBean{}, i=9}", exampleBean.toString());
    }
}
