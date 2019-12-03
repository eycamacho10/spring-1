package com.globant.spring.e.controllers;

public class CustomBean {

    private final String name;

    public CustomBean(String name) {
        this.name = name;
    }

    public void greeting() {
        System.out.println("Greeting from " + this.name + " of type " + this.getClass().getName());
    }
}
