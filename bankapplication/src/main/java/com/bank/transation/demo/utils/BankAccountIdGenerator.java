package com.bank.transation.demo.utils;

import java.util.Random;

/**
 * A utility class for generating random bank account IDs.
 * <p>
 * This class provides a static method {@code generateAccountId} to generate a
 * random bank account ID
 * following the format of two uppercase letters followed by 10 digits.
 */
public class BankAccountIdGenerator {

    /**
     * A {@code Random} instance used for generating random characters and digits.
     */
    private static final Random RANDOM = new Random();

    /**
     * A string containing uppercase alphabet letters used for generating the first
     * two characters
     * of the account ID.
     */
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * The length of the generated bank account ID.
     */
    private static final int ACCOUNT_ID_LENGTH = 12;

    /**
     * Generates a random bank account ID in the format of two uppercase letters
     * followed by ten digits.
     *
     * @return A randomly generated bank account ID string.
     */
    public static String generateAccountId() {
        StringBuilder accountId = new StringBuilder(ACCOUNT_ID_LENGTH);

        // Generate the first two uppercase letters
        for (int i = 0; i < 2; i++) {
            accountId.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        // Generate the remaining ten digits
        for (int i = 0; i < 10; i++) {
            accountId.append(RANDOM.nextInt(10));
        }

        return accountId.toString();
    }
}
