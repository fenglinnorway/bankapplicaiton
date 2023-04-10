package com.bank.transation.demo.utils;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountIdValidatorTest {

    @Test
    void isValid_withValidAccountId() {
        String validAccountId = "CP1294857630";
        assertTrue(BankAccountIdValidator.isValid(validAccountId));
    }

    @Test
    public void testValidBankAccountId() {
        String validAccountId = "AB1234567890";
        assertTrue(BankAccountIdValidator.isValid(validAccountId), "Expected valid bank account ID to pass validation");
    }

    @Test
    public void testInvalidBankAccountIdLowercaseLetters() {
        String invalidAccountId = "ab1234567890";
        assertFalse(BankAccountIdValidator.isValid(invalidAccountId),
                "Expected invalid bank account ID with lowercase letters to fail validation");
    }

    @Test
    public void testInvalidBankAccountIdTooShort() {
        String invalidAccountId = "AB123456789";
        assertFalse(BankAccountIdValidator.isValid(invalidAccountId),
                "Expected invalid bank account ID with too few digits to fail validation");
    }

    @Test
    public void testInvalidBankAccountIdTooLong() {
        String invalidAccountId = "AB12345678901";
        assertFalse(BankAccountIdValidator.isValid(invalidAccountId),
                "Expected invalid bank account ID with too many digits to fail validation");
    }

    @Test
    public void testInvalidBankAccountIdWithSpecialCharacters() {
        String invalidAccountId = "A!1234567890";
        assertFalse(BankAccountIdValidator.isValid(invalidAccountId),
                "Expected invalid bank account ID with special characters to fail validation");
    }

    @Test
    public void testInvalidBankAccountIdWithWhitespace() {
        String invalidAccountId = "AB 123456789";
        assertFalse(BankAccountIdValidator.isValid(invalidAccountId),
                "Expected invalid bank account ID with whitespace to fail validation");
    }
    // Add more test cases if needed
}
