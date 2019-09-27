package com.globant.spring.a.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class MessageSystem {

    private MessageService messageService;

    public MessageSystem(MessageService messageService) {
        this.messageService = messageService;
    }

    public void bulkMessages(List<String> messages) {
        messages.forEach(message ->
                messageService.sendMessage(message)
        );
    }

    public static void main(String... args) {
        List<String> messages = Arrays.asList("message1","message2","message3");
        //Below is not used injection
        MessageSystem system = new MessageSystem(new MessageService());
        system.bulkMessages(messages);

        //Bellow use bean to inject
        // Read the Spring configuration file [SpringConfig.xml]
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config.xml");
        // Get instance
        MessageService messageService = (MessageService) appContext.getBean("messageService");
        MessageSystem systemUsingInject = new MessageSystem(messageService);
        system.bulkMessages(messages);
    }
}
