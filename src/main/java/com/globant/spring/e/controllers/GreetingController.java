package com.globant.spring.e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private RequestMessage requestMessage;

    @Autowired
    public GreetingController(RequestMessage requestMessage) {
        this.requestMessage = requestMessage;
        System.out.println("Constructor GreetingController");
    }

    public GreetingController() {
        System.out.println("Constructor GreetingController");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        requestMessage.setMessage("Hello " + name);
        return requestMessage.getMessage();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/message")
    public String message() {
        return requestMessage.getMessage();
    }
}
