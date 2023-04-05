package com.bank.transation.demo.utils;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountIdValidatorTest {

    @Test
    void isValid_withValidAccountId() {
        String validAccountId = "CP1294857630";
        assertTrue(BankAccountIdValidator.isValid(validAccountId));
    }

    // Add more test cases if needed
}
