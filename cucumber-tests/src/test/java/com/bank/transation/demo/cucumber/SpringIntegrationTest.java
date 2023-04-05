package com.bank.transation.demo.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.bank.transation.demo.BankApplication;
import com.bank.transation.demo.model.dto.TransferRequest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.bank.transation.demo.model.bank.*;

import io.cucumber.java.en.And;
import java.util.List;
import java.util.Arrays;
import java.io.IOException;
import java.sql.Date;

@SpringBootTest(classes = BankApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@CucumberContextConfiguration
public class SpringIntegrationTest {
    static ResponseResults latestResponse = null;
    @Autowired
    protected RestTemplate restTemplate;

    private Account testAccount;
    private List<MoneyTransferEvent> testMiniStatements;
    private Date testDate = java.sql.Date.valueOf(java.time.LocalDate.now());

    TransferRequest getTreansferRequest(String from, String to, int amount) {
        return TransferRequest.builder().fromAccountId(from).toAccountId(to).amount(amount).build();
    }

    void executeGet(String url) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(url, HttpMethod.GET, requestCallback, response -> {
            if (errorHandler.hadError) {
                return (errorHandler.getResults());
            } else {
                return (new ResponseResults(response));
            }
        });
    }

    void executeTransferPost(String from, String to, int amount) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        requestCallback.setBody(getTreansferRequest(from, to, amount).toString());
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate
                .execute("http://localhost:9010/transfer", HttpMethod.POST, requestCallback, response -> {
                    if (errorHandler.hadError) {
                        return (errorHandler.getResults());
                    } else {
                        return (new ResponseResults(response));
                    }
                });
    }

    private class ResponseResultErrorHandler implements ResponseErrorHandler {
        private ResponseResults results = null;
        private Boolean hadError = false;

        private ResponseResults getResults() {
            return results;
        }

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            hadError = response.getRawStatusCode() >= 400;
            return hadError;
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            results = new ResponseResults(response);
        }
    }


    @Given("valid account details and positive funds available")
    public void givenValidAccountDetailsAndPositiveFundsAvailable() {
        // Inintialize a account with account id AB1234567890 and positive funds
        testAccount = Account.builder().accountId("AB1234567890").currency("gbp").balance(10000).build();

        testMiniStatements = Arrays.asList(
                MoneyTransferEvent.builder().accountId("AB1234567890").amount(100).currency("gbp")
                        .transitionType(TransactionType.TYPE.CREDIT.name()).transactionDate(
                                testDate)
                        .build());
    }

    @When("account-id AB1234567890 sends {int} to account-id DE1234567890")
    public void whenAccountAB1234567890SendsAmountToAccountDE1234567890(int amount) throws IOException {
        // Perform the transfer between the two accounts
        executeTransferPost("AB1234567890", "DE1234567890", amount);
    }

    @Then("account-id AB1234567890 account should be debited with {int}")
    public void thenAccountAB1234567890AccountShouldBeDebitedWithAmount(int amount) {
        // Check if the sender's account has been debited with the specified amount
    }

    @And("account-id DE1234567890 account should be credited with {int}")
    public void andAccountDE1234567890AccountShouldBeCreditedWithAmount(int amount) {
        // Check if the receiver's account has been credited with the specified amount
    }
}