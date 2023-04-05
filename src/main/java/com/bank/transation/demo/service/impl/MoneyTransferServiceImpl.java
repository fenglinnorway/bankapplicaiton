package com.bank.transation.demo.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.bank.transation.demo.model.bank.*;
import com.bank.transation.demo.repository.AccountRepository;
import com.bank.transation.demo.repository.TransitionRepository;
import com.bank.transation.demo.service.MoneyTransferService;
import com.bank.transation.demo.utils.BankAccountIdValidator;
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
        if (!BankAccountIdValidator.isValid(fromAccountId) || !BankAccountIdValidator.isValid(toAccountId)) {
            throw new IllegalArgumentException("Invalid account ID format" + fromAccountId + " or " + toAccountId + "");
        }

        Account fromAccount = accountRepository.findByAccountId(fromAccountId);
        Account toAccount = accountRepository.findByAccountId(toAccountId);
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account ID + " + fromAccountId + " or " + toAccountId + "");
        }
        // Check if the fromAccount has enough balance for withdrawal
        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance in the fromAccount");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        MoneyTransferEvent withdrawalEvent = new MoneyTransferEvent();
        withdrawalEvent.setAccountId(fromAccount.getAccountId());
        withdrawalEvent.setAmount(amount);
        withdrawalEvent.setTransitionType(TransactionType.TYPE.DEBIT.name());
        withdrawalEvent.setCurrency(fromAccount.getCurrency());
        withdrawalEvent.setTransactionDate(new java.sql.Date(System.currentTimeMillis()));

        MoneyTransferEvent depositEvent = new MoneyTransferEvent();
        depositEvent.setAccountId(toAccount.getAccountId());
        depositEvent.setAmount(amount);
        depositEvent.setTransitionType(TransactionType.TYPE.CREDIT.name());
        depositEvent.setCurrency(fromAccount.getCurrency());
        depositEvent.setTransactionDate(new java.sql.Date(System.currentTimeMillis()));

        transitionRepository.save(withdrawalEvent);
        transitionRepository.save(depositEvent);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'transferMoney'");
    }
}
