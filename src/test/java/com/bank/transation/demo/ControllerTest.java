package com.bank.transation.demo;

import com.bank.transation.demo.controller.AccountController;
import com.bank.transation.demo.controller.TransferController;
import com.bank.transation.demo.service.AccountService;
import com.bank.transation.demo.service.MoneyTransferService;
import com.bank.transation.demo.service.TransitionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
    @Mock
    AccountService accountService;
    @Mock
    MoneyTransferService transferService;
    @Mock
    TransitionService transitionService;
    
    private MockMvc accountMoc;
    private MockMvc transferMoc;
    private final ObjectMapper mapper = new ObjectMapper();
    private static  final Logger log = LoggerFactory.getLogger(ControllerTest.class);

    @Before
    public void setup() {
        AccountController accountController = new AccountController(accountService, transitionService);
        TransferController transferController = new TransferController(transferService);
        accountMoc = MockMvcBuilders.standaloneSetup(accountController).build();
        transferMoc = MockMvcBuilders.standaloneSetup(transferController).build();

    }

 



    @Test
    public void should_get_account_ById() throws Exception {
        String target = "/accounts";
        accountMoc.perform(get(target).param( "1")).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void should_transfer_money_if_account_is_valid() throws Exception {
        String target = "/accounts/transfer";
        accountMoc.perform(post(target).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString("1"))).andExpect(status().is2xxSuccessful());
    }


}
