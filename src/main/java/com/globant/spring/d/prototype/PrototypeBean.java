package com.globant.spring.d.prototype;

public class PrototypeBean {

    //It shouldn't be here. It's just for the exercise
    private String message;

    public String process() {
        System.out.println("Scope -> prototype");
        this.message = "using prototype scope, the message is missed";
        return "prototype bean";
    }

    public String getMessage() {
        return this.message;
    }
}
