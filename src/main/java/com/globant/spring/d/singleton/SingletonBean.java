package com.globant.spring.d.singleton;

public class SingletonBean {

    //It shouldn't be here. It's just for the exercise
    private String message;

    public String process() {
        System.out.println("Process -> singleton bean");
        this.message = "using singleton scope, the message is held";
        return "singleton bean";
    }

    public String getMessage() {
        return message;
    }
}
