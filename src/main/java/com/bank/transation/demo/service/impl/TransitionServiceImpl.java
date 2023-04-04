package com.bank.transation.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.transation.demo.model.bank.*;
import com.bank.transation.demo.repository.TransitionRepository;
import com.bank.transation.demo.service.TransitionService;

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
        return transitionRepository.getMiniStatement(accountId);
    }
}
