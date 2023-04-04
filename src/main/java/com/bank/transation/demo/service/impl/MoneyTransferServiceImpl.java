package com.bank.transation.demo.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.bank.transation.demo.model.bank.*;
import com.bank.transation.demo.repository.AccountRepository;
import com.bank.transation.demo.repository.TransitionRepository;
import com.bank.transation.demo.service.MoneyTransferService;

import org.springframework.stereotype.Service;

/**
 * MoneyTransferServiceImpl is a service class responsible for handling money
 * transfer operations between accounts.
 * It implements the MoneyTransferService interface.
 */
@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {

    // Account repository to interact with Account data in the database
    private AccountRepository accountRepository;

    // Transition repository to interact with MoneyTransferEvent data in the
    // database
    private TransitionRepository transitionRepository;

    /**
     * Constructs a new MoneyTransferServiceImpl with the given AccountRepository
     * and TransitionRepository.
     *
     * @param accountRepository    the AccountRepository to be used for
     *                             account-related operations
     * @param transitionRepository the TransitionRepository to be used for
     *                             transition-related operations
     */
    public MoneyTransferServiceImpl(AccountRepository accountRepository, TransitionRepository transitionRepository) {
        this.accountRepository = accountRepository;
        this.transitionRepository = transitionRepository;
    }

    /**
     * Transfers the specified amount of money from one account to another.
     * The method is transactional, ensuring that all operations are atomic.
     * If any part of the operation fails, the entire transaction is rolled back.
     *
     * @param fromAccountId the source account ID
     * @param toAccountId   the target account ID
     * @param amount        the amount of money to be transferred
     * @throws IllegalArgumentException if the source account does not have enough
     *                                  balance for the withdrawal
     */
    @Transactional
    @Override
    public void transferMoney(String fromAccountId, String toAccountId, Integer amount) {
        // ... (Implementation remains the same)
    }
}
