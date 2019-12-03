package com.globant.spring.e.controllers;

import com.globant.spring.configuration.MainApplication;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CustomScopeTest {

    @Test
    public void testCustomScope() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MainApplication.class);
        ctx.refresh();

        CustomBean customBean = (CustomBean) ctx.getBean("customBean", CustomBean.class);
        customBean.greeting();
        Map<String, CustomBean> customBeanMap = ctx.getBeansOfType(CustomBean.class);
        assertThat(customBeanMap.size(), equalTo(1));
        BeanDefinition customDefinition = ctx.getBeanDefinition("customBean");
        assertThat(customDefinition.getScope(), equalTo("custom-scope"));
    }
}
