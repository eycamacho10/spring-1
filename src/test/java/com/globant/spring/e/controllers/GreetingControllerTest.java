package com.globant.spring.e.controllers;

import com.globant.spring.configuration.SpringBootConfigurationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GreetingControllerTest extends SpringBootConfigurationTests {

    private static final String MESSAGE = "Hello World";
    private static final String MESSAGE_SAVED = MESSAGE + " - message saved";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRequestScopeGreeting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/greeting")
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(MESSAGE));
        mockMvc.perform(MockMvcRequestBuilders
                .get("/message")
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testSessionScopeGreeting() throws Exception {
        MockHttpSession mocksession = new MockHttpSession();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/persist/greeting")
                .session(mocksession)
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(MESSAGE_SAVED));
        mockMvc.perform(MockMvcRequestBuilders
                .get("/persist/message")
                .session(mocksession)
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(MESSAGE_SAVED));
    }
}
