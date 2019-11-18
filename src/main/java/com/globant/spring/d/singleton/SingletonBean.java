package com.globant.spring.d.singleton;

public class SingletonBean {

    public String process() {
        System.out.println("Process -> singleton bean");
        return "singleton bean";
    }
}
