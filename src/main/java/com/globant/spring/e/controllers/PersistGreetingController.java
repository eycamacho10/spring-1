package com.globant.spring.e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersistGreetingController {

    private SessionMessage sessionMessage;

    @Autowired
    public PersistGreetingController(SessionMessage sessionMessage) {
        this.sessionMessage = sessionMessage;
        System.out.println("Constructor PersistGreetingController");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/persist/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        sessionMessage.setMessage("Hello " + name + " - message saved");
        return sessionMessage.getMessage();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/persist/message")
    public String message() {
        return sessionMessage.getMessage();
    }
}
