package com.globant.spring.e.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class SessionMessage {
    private String message;

    public SessionMessage() {
        System.out.println("<------------ Constructor SessionMessage ------------>");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
