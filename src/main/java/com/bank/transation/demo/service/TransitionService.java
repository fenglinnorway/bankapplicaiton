package com.bank.transation.demo.service;

import java.util.List;

import com.bank.transation.demo.model.bank.*;
public interface TransitionService {
    // Method to find an Account by its accountId
    List<MoneyTransferEvent> miniStatements(String accountId);
}
