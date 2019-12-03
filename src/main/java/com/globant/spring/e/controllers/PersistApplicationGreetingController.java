package com.globant.spring.e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersistApplicationGreetingController {

    private ApplicationMessage applicationMessage;

    @Autowired
    public PersistApplicationGreetingController(ApplicationMessage applicationMessage) {
        this.applicationMessage = applicationMessage;
        System.out.println("Constructor PersistApplicationGreetingController");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/persist/application/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        applicationMessage.setMessage("Hello " + name + " - application message saved");
        return applicationMessage.getMessage();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/persist/application/message")
    public String message() {
        return applicationMessage.getMessage();
    }
}
