package com.globant.spring.e.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class RequestMessage {
    private String message;

    public RequestMessage() {
        System.out.println("<------------ Constructor RequestMessage ------------>");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
