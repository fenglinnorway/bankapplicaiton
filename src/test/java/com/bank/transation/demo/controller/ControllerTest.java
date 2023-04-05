package com.bank.transation.demo.controller;

import com.bank.transation.demo.controller.AccountController;
import com.bank.transation.demo.service.AccountService;
import com.bank.transation.demo.service.TransitionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Mock
    AccountService accountService;
    @Mock
    TransitionService transitionService;
    
    private MockMvc accountMoc;
    private final ObjectMapper mapper = new ObjectMapper();
    private static  final Logger log = LoggerFactory.getLogger(ControllerTest.class);

    @Before
    public void setup() {
        AccountController accountController = new AccountController(accountService, transitionService);
        accountMoc = MockMvcBuilders.standaloneSetup(accountController).build();

    }

 



    @Test
    public void should_get_account_ById() throws Exception {
        String target = "/accounts/{id}/balance";
        accountMoc.perform(get(target).param( "HZ7351968402")).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void should_transfer_money_if_account_is_valid() throws Exception {
        String jsonBody =  """
        {
        "fromAccountId": "1",
        "toAccountId": "2",
        "amount": 543
        }
        """;

        String target = "/transfer";
        accountMoc.perform(post(target).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(jsonBody))).andExpect(status().is2xxSuccessful());
    }


}
