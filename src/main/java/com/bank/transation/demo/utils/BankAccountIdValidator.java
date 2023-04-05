package com.bank.transation.demo.utils;

import java.util.regex.Pattern;

/**
 * A utility class for validating bank account IDs.
 * <p>
 * This class provides a static method {@code isValid} to check if a given
 * account ID matches the expected format.
 * In this example, the expected format is two uppercase letters followed by 10
 * digits.
 */
public class BankAccountIdValidator {

    /**
     * A regular expression pattern to match the expected bank account ID format.
     * The pattern checks for two uppercase letters followed by ten digits.
     */
    private static final Pattern ACCOUNT_ID_PATTERN = Pattern.compile("^[A-Z]{2}\\d{10}$");

    /**
     * Validates a bank account ID against the expected format.
     *
     * @param accountId The bank account ID to validate.
     * @return {@code true} if the account ID matches the expected format,
     *         {@code false} otherwise.
     */
    public static boolean isValid(String accountId) {
        return ACCOUNT_ID_PATTERN.matcher(accountId).matches();
    }
}
