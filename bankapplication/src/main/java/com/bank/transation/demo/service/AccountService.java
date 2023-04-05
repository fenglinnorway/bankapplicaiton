package com.bank.transation.demo.service;

import com.bank.transation.demo.model.bank.Account;

/**
 * The AccountService interface defines the methods related to account
 * management operations.
 * Implementations of this interface should provide the necessary logic to
 * handle these operations.
 */
public interface AccountService {

    /**
     * Finds and returns an Account object by its accountId.
     *
     * @param accountId the accountId of the Account to be retrieved
     * @return the Account object with the specified accountId, or null if no such
     *         account exists
     */
    Account findByAccountId(String accountId);

    /**
     * Retrieves the balance of an Account by its accountId.
     *
     * @param accountId the accountId of the Account whose balance is to be
     *                  retrieved
     * @return the balance of the Account with the specified accountId, or null if
     *         no such account exists
     */
    Integer getBalance(String accountId);

    // Method to create a new Account
    // Account createAccount();
}
