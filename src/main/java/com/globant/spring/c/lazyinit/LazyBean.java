package com.globant.spring.c.lazyinit;

public class LazyBean {

    public LazyBean() {
        System.out.println("LazyBean -> constructor ");
    }

    public String process() {
        System.out.println("LazyBean -> process ");
        return "message from LazyBean -> process";
    }
}
