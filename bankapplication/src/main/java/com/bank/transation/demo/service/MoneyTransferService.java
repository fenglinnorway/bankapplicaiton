package com.bank.transation.demo.service;

/**
 * The MoneyTransferService interface defines the methods related to money
 * transfer operations.
 * Implementations of this interface should provide the necessary logic to
 * handle these operations.
 */
public interface MoneyTransferService {

    /**
     * Transfers a specified amount of money between two accounts. The method will
     * update
     * the balances of both the sender and the receiver accounts and create
     * corresponding
     * transaction records in the system.
     *
     * @param fromAccountId the accountId of the sender account from which the
     *                      amount will be withdrawn
     * @param toAccountId   the accountId of the receiver account to which the
     *                      amount will be deposited
     * @param amount        the amount of money to be transferred between the
     *                      accounts
     * @throws IllegalArgumentException if the sender account has insufficient
     *                                  balance for the transfer
     */
    public void transferMoney(String fromAccountId, String toAccountId, Integer amount);
}
