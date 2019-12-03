package com.globant.spring.configuration;

import com.globant.spring.e.controllers.CustomBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@SpringBootApplication(scanBasePackages = {"com.globant.spring.e.controllers"})
@ImportResource({"classpath*:spring-config.xml"})
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }

    @Scope(scopeName = "custom-scope")
    @Bean
    public CustomBean customBean() {
        return new CustomBean("custom-scope");
    }
}
