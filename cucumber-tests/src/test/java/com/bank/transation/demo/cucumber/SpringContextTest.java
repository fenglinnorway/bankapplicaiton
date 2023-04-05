package com.bank.transation.demo.cucumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.transation.demo.BankApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankApplication.class)
public class SpringContextTest {
    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
