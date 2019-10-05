package com.globant.spring.b.beanoverview;

import com.globant.spring.a.ioc.MessageService;

public class MessageServiceWithConstructor {

    private static final String RESPONSE = "The message object was sent! using constructor IoC";

    private String company;
    private MessageService messageService;

    public MessageServiceWithConstructor(String company) {
        this.company = company;
    }

    public MessageServiceWithConstructor(MessageService messageService) {
        this.messageService = messageService;
    }

    public String sendMessageUsingCompany(String message) {
        //It could be some logic
        System.out.println(message);
        return "Company: " + this.company + RESPONSE + message;
    }

    public String sendMessageUsingService(String message) {
        //It could be some logic
        System.out.println(message);
        return "Super message: " + this.messageService.sendMessage(message);
    }
}
