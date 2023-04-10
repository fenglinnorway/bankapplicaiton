package com.bank.transation.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DefaultControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRedirect() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(header().string("Location", "swagger-ui-custom.html"));
    }

    @Test
    public void testDatabaseUrl() throws Exception {
        mockMvc.perform(get("/database"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(header().string("Location", "h2-console"));
    }
}
