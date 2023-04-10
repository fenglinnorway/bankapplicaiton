package com.bank.transation.demo.service.impl;

import com.bank.transation.demo.model.bank.Account;
import com.bank.transation.demo.model.bank.MoneyTransferEvent;
import com.bank.transation.demo.repository.AccountRepository;
import com.bank.transation.demo.repository.TransitionRepository;
import com.bank.transation.demo.service.impl.AccountServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
    
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountServiceImpl accountService;
    private Account account;

    @BeforeEach
    public void setUp() {
        account = Account.builder()
                .id(1)
                .accountId("CP1294857630")
                .balance(1000)
                .currency("gbp")
                .build();

    }

    @Test
    public void checkAccountBalance_success() {
        String accountId = account.getAccountId();
        when(accountRepository.findByAccountId(accountId)).thenReturn(Optional.of(account));

        Integer balance = accountService.findByAccountId(accountId).get().getBalance();

        assertEquals(account.getBalance(), balance);

        verify(accountRepository, times(1)).findByAccountId(accountId);
    }
}
