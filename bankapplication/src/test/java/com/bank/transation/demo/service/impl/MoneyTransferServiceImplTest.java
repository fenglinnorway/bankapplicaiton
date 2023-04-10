package com.bank.transation.demo.service.impl;

import com.bank.transation.demo.model.bank.Account;
import com.bank.transation.demo.model.bank.MoneyTransferEvent;
import com.bank.transation.demo.repository.AccountRepository;
import com.bank.transation.demo.repository.TransitionRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MoneyTransferServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransitionRepository transitionRepository;

    @InjectMocks
    private MoneyTransferServiceImpl moneyTransferService;

    private Account fromAccount;
    private Account toAccount;
    private Integer transferAmount;

    @BeforeEach
    public void setUp() {
        fromAccount = Account.builder()
                .id(1)
                .accountId("XM9485720136")
                .balance(1000)
                .currency("USD")
                .build();

        toAccount = Account.builder()
                .id(2)
                .accountId("HZ7351968402")
                .balance(500)
                .currency("USD")
                .build();

        transferAmount = 250;
    }

    @Test
    public void transferMoney_success() {
        when(accountRepository.findByAccountId(fromAccount.getAccountId())).thenReturn(Optional.of(fromAccount));
        when(accountRepository.findByAccountId(toAccount.getAccountId())).thenReturn(Optional.of(toAccount));
        when(accountRepository.save(any(Account.class))).thenReturn(null);
        when(transitionRepository.save(any(MoneyTransferEvent.class))).thenReturn(null);

        moneyTransferService.transferMoney(fromAccount.getAccountId(), toAccount.getAccountId(), transferAmount);

        verify(accountRepository, times(1)).findByAccountId(fromAccount.getAccountId());
        verify(accountRepository, times(1)).findByAccountId(toAccount.getAccountId());
        verify(accountRepository, times(2)).save(any(Account.class));
        verify(transitionRepository, times(2)).save(any(MoneyTransferEvent.class));
    }

    @Test
    public void transferMoney_insufficientBalance() {
        Integer insufficientAmount = 1500;
        when(accountRepository.findByAccountId(fromAccount.getAccountId())).thenReturn(Optional.of(fromAccount));
        when(accountRepository.findByAccountId(toAccount.getAccountId())).thenReturn(Optional.of(toAccount));

        assertThrows(IllegalArgumentException.class, () -> {
            moneyTransferService.transferMoney(fromAccount.getAccountId(), toAccount.getAccountId(),
                    insufficientAmount);
        });

        verify(accountRepository, times(1)).findByAccountId(fromAccount.getAccountId());
        verify(accountRepository, times(1)).findByAccountId(toAccount.getAccountId());
        verify(accountRepository, times(0)).save(any(Account.class));
        verify(transitionRepository, times(0)).save(any(MoneyTransferEvent.class));
    }

    @Test
    public void transferMoney_non_existing_ReceiverAccount() {
        String nonExstingAccountId = "HZ7351968402";
        Integer senderAmount = 10;

        when(accountRepository.findByAccountId(fromAccount.getAccountId())).thenReturn(Optional.of(fromAccount));
        when(accountRepository.findByAccountId(nonExstingAccountId)).thenReturn(Optional.empty());

        assertThrows(java.util.NoSuchElementException.class, () -> {
            moneyTransferService.transferMoney(fromAccount.getAccountId(), nonExstingAccountId, senderAmount);
        });

        verify(accountRepository, times(1)).findByAccountId(fromAccount.getAccountId());
        verify(accountRepository, times(1)).findByAccountId(nonExstingAccountId);
        verify(accountRepository, times(0)).save(any(Account.class));
        verify(transitionRepository, times(0)).save(any(MoneyTransferEvent.class));
    }

    @Test
    public void transferMoney_invalidAccountId() {
        String invalidAccountId = "23";
        Integer senderAmount = 10;

        assertThrows(IllegalArgumentException.class, () -> {
            moneyTransferService.transferMoney(fromAccount.getAccountId(), invalidAccountId, senderAmount);
        });
    }
}
