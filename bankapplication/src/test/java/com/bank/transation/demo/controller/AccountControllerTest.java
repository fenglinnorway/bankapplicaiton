package com.bank.transation.demo.controller;

import com.bank.transation.demo.controller.AccountController;
import com.bank.transation.demo.model.bank.Account;
import com.bank.transation.demo.model.bank.MoneyTransferEvent;
import com.bank.transation.demo.model.bank.TransactionType;
import com.bank.transation.demo.service.AccountService;
import com.bank.transation.demo.service.TransitionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;
import java.sql.Date;
import com.jayway.jsonpath.JsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TransitionService transitionService;

    private Account testAccount;
    private List<MoneyTransferEvent> testMiniStatements;
    private Date testDate= java.sql.Date.valueOf(java.time.LocalDate.now());

    @BeforeEach
    void setUp() {
        testAccount = Account.builder().accountId("AB1234567890").currency("gbp").balance(10000).build();

        testMiniStatements = Arrays.asList(
                MoneyTransferEvent.builder().accountId("AB1234567890").amount(100).currency("gbp")
                        .transitionType(TransactionType.TYPE.CREDIT.name()).transactionDate(
                                testDate)
                        .build());

        Mockito.when(accountService.findByAccountId("AB1234567890")).thenReturn(Optional.of(testAccount));
        Mockito.when(transitionService.miniStatements("AB1234567890")).thenReturn(testMiniStatements);

        // Add print statements
        System.out.println("Test account: " + testAccount.toString());
        System.out.println("Test mini statements: " + testMiniStatements.toString());
    }

    @Test
    void findById() throws Exception {

        String response = mockMvc.perform(get("/accounts/AB1234567890/balance"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("-----" + response + "--asdf---");
        assertThat(JsonPath.read(response, "$.accountId"), is("AB1234567890")); 
        assertThat(JsonPath.read(response, "$.balance"), is(10000));
        assertThat(JsonPath.read(response, "$.currency"), is("gbp"));

    }

    @Test
    void getMiniStatements() throws Exception {
        String response = mockMvc.perform(get("/accounts/AB1234567890/statements/mini"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("-----"+response+"---asdf--");
        assertThat(JsonPath.read(response, "$[0].accountId"), is("AB1234567890"));
        assertThat(JsonPath.read(response, "$[0].amount"), is(100));
        assertThat(JsonPath.read(response, "$[0].currency"), is("gbp"));
        assertThat(JsonPath.read(response, "$[0].transitionType"), is("CREDIT"));
        assertThat(JsonPath.read(response, "$[0].transactionDate"), is(testDate.toString()));
    }

}
