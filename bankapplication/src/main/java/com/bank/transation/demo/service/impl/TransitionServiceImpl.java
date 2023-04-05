package com.bank.transation.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.bank.transation.demo.model.bank.*;
import com.bank.transation.demo.repository.TransitionRepository;
import com.bank.transation.demo.service.TransitionService;
import com.bank.transation.demo.utils.BankAccountIdValidator;
import java.util.List;

@Service
public class TransitionServiceImpl implements TransitionService{

    private TransitionRepository transitionRepository;

    @Autowired
    public TransitionServiceImpl(TransitionRepository transitionRepository) {
        this.transitionRepository = transitionRepository;
    }
    

    // Implementation of the findByAccountId method from the AccountService
    // interface
    @Override
    public List<MoneyTransferEvent> miniStatements(String accountId) {
        int maxResults = 20;
        if (!BankAccountIdValidator.isValid(accountId)) {
            throw new IllegalArgumentException("Invalid account ID format");
        }
        Pageable pageable = PageRequest.of(0, maxResults, Sort.by(Sort.Direction.DESC, "transactionDate"));
        return transitionRepository.getMiniStatement(accountId, pageable);
    }

    
}
