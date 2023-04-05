package com.bank.transation.demo.service;

import com.bank.transation.demo.model.bank.MoneyTransferEvent;
import com.bank.transation.demo.repository.TransitionRepository;
import com.bank.transation.demo.service.impl.TransitionServiceImpl;
import com.bank.transation.demo.utils.UtilityHelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransitionServiceImplTest {

    @Mock
    private TransitionRepository transitionRepository;

    @InjectMocks
    private TransitionServiceImpl transitionService;

    private List<MoneyTransferEvent> events;

    @BeforeEach
    public void setUp() {
        events = UtilityHelper.moneyTransferEventSupplier.get();
    }

    @Test
    public void testMiniStatements() {
        String accountId = "XM9485720136";
        int maxResults = 20;
        Pageable pageable = PageRequest.of(0, maxResults, Sort.by(Sort.Direction.DESC, "transactionDate"));

        when(transitionRepository.getMiniStatement(eq(accountId), eq(pageable))).thenReturn(events);

        List<MoneyTransferEvent> result = transitionService.miniStatements(accountId);

        assertEquals(events.size(), result.size());
        verify(transitionRepository, times(1)).getMiniStatement(accountId, pageable);
    }
}
