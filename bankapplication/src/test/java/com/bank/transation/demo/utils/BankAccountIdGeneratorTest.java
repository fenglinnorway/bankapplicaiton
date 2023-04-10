package com.bank.transation.demo.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountIdGeneratorTest {

    @Test
    public void testGeneratedAccountIdLength() {
        String generatedAccountId = BankAccountIdGenerator.generateAccountId();
        assertEquals(12, generatedAccountId.length(), "Generated account ID should have 12 characters");
    }

    @Test
    public void testGeneratedAccountIdFormat() {
        String generatedAccountId = BankAccountIdGenerator.generateAccountId();
        String accountIdPattern = "^[A-Z]{2}\\d{10}$";
        assertTrue(generatedAccountId.matches(accountIdPattern),
                "Generated account ID should match the expected pattern");
    }
}
