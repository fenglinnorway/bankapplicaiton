package com.bank.transation.demo.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources/features/transfer.feature", 
glue = "com.bank.transation.demo")

public class CucumberIntegrationTest{
}