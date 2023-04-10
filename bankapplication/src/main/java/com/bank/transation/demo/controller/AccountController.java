/**
 * The AccountController class is a REST controller that exposes API endpoints for managing
 * bank accounts and retrieving account-related information.
 */
package com.bank.transation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.transation.demo.annotation.LogObjectAfter;
import com.bank.transation.demo.annotation.LogObjectBefore;
import com.bank.transation.demo.model.bank.*;
import com.bank.transation.demo.service.AccountService;
import com.bank.transation.demo.service.TransitionService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService service;
    private TransitionService transitionService;

    /**
     * Constructs a new AccountController with the specified AccountService and
     * TransitionService instances.
     *
     * @param service           the account service to be used
     * @param transitionService the transition service to be used
     */
    @Autowired
    public AccountController(AccountService service, TransitionService transitionService) {
        this.service = service;
        this.transitionService = transitionService;
    }

    /**
     * Retrieves the account details for a given account ID.
     *
     * @param id the account ID
     * @return a ResponseEntity containing the account details
     */
    @LogObjectAfter
    @GetMapping("/{id}/balance")
    public ResponseEntity<Account> findById(@PathVariable String id) {
        Account account = service.findByAccountId(id).get();
        return ResponseEntity.ok().body(account);
    }

    /**
     * Retrieves a list of mini statement events for a given account ID.
     *
     * @param id the account ID
     * @return a ResponseEntity containing the list of mini statement events
     */
    @LogObjectAfter
    @GetMapping("/{id}/statements/mini")
    public ResponseEntity<List<MoneyTransferEvent>> getMiniStatements(@PathVariable String id) {
        List<MoneyTransferEvent> events = transitionService.miniStatements(id);
        return ResponseEntity.ok().body(events);
    }
}
