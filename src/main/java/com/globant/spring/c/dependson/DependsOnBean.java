package com.globant.spring.c.dependson;

public class DependsOnBean {

    public DependsOnBean() {
        System.out.println("DependsOnBean -> constructor ");
    }

    public String process() {
        System.out.println("DependsOnBean -> process ");
        return "message from DependsOnBean -> process";
    }
}
