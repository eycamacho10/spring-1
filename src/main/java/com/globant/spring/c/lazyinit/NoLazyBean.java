package com.globant.spring.c.lazyinit;

public class NoLazyBean {

    public NoLazyBean() {
        System.out.println("NoLazyBean -> constructor ");
    }

    public String process() {
        System.out.println("NoLazyBean -> process ");
        return "message from NoLazyBean -> process";
    }
}
