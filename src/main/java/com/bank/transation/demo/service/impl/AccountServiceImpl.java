package com.bank.transation.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.transation.demo.model.bank.Account;
import com.bank.transation.demo.repository.AccountRepository;
import com.bank.transation.demo.service.AccountService;
import com.bank.transation.demo.utils.BankAccountIdValidator;

/**
 * The {@code AccountServiceImpl} class is an implementation of the
 * {@link com.bank.transation.demo.service.AccountService} interface. This
 * service
 * class is responsible for handling operations related to
 * {@link com.bank.transation.demo.model.bank.Account}
 * objects.
 * <p>
 * This class uses the
 * {@link com.bank.transation.demo.repository.AccountRepository}
 * to interact with the data layer.
 */
@Service
public class AccountServiceImpl implements AccountService {

    // The AccountRepository instance used for data layer interactions
    private AccountRepository repository;

    /**
     * Constructor for the {@code AccountServiceImpl} class. Initializes the
     * {@link com.bank.transation.demo.repository.AccountRepository} dependency
     * using constructor-based dependency injection.
     *
     * @param repository The AccountRepository instance to be used for data layer
     *                   interactions
     */
    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds and returns an {@link com.bank.transation.demo.model.bank.Account}
     * object by its accountId.
     *
     * @param accountId The account ID for which the account object should be
     *                  retrieved
     * @return The Account object with the specified accountId, or null if no such
     *         account exists
     */
    @Override
    public Account findByAccountId(String accountId) {
        if (!BankAccountIdValidator.isValid(accountId)) {
            throw new IllegalArgumentException("Invalid account ID format");
        }
        return repository.findByAccountId(accountId);
    }

    /**
     * Retrieves the balance for a specific account using its accountId.
     *
     * @param accountId The account ID for which the balance should be retrieved
     * @return The balance of the account with the specified accountId, or null if
     *         no such account exists
     */
    @Override
    public Integer getBalance(String accountId) {
        if (!BankAccountIdValidator.isValid(accountId)) {
            throw new IllegalArgumentException("Invalid account ID format");
        }
        return repository.findByAccountId(accountId).getBalance();
    }
}
