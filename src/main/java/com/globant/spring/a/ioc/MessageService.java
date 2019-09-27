package com.globant.spring.a.ioc;

public class MessageService {

    private static final String RESPONSE = "The message was sent! ";

    public String sendMessage(String message) {
        //It could be some logic
        System.out.println(message);
        return RESPONSE + message;
    }
}
