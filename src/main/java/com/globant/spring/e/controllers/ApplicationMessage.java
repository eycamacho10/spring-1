package com.globant.spring.e.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class ApplicationMessage {
    private String message;

    public ApplicationMessage() {
        System.out.println("<------------ Constructor ApplicationMessage ------------>");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
