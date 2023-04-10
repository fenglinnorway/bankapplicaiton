package com.bank.transation.demo.controller;

import com.bank.transation.demo.model.dto.TransferRequest;
import com.bank.transation.demo.service.MoneyTransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MoneyTransferService moneyTransferService;

    @Test
    public void testTransferMoney() throws Exception {
        String fromAccountId = "AB1234567890";
        String toAccountId = "CD9876543210";
        int amount = 100;

        TransferRequest request = TransferRequest.builder()
                .fromAccountId(fromAccountId)
                .toAccountId(toAccountId)
                .amount(amount)
                .build();

        String jsonRequest = "{\"fromAccountId\":\"AB1234567890\",\"toAccountId\":\"CD9876543210\",\"amount\":100}";

        doNothing().when(moneyTransferService).transferMoney(fromAccountId, toAccountId, amount);

        mockMvc.perform(post("/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().string("Money transfer successful"));

        verify(moneyTransferService, times(1)).transferMoney(fromAccountId, toAccountId, amount);
    }
}
