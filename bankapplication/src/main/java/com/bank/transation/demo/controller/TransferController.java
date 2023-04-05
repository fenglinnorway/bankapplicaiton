package com.bank.transation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.transation.demo.model.dto.TransferRequest;
import com.bank.transation.demo.service.MoneyTransferService;

import org.springframework.http.HttpStatus;

/**
 * This class represents the controller for money transfer operations.
 * It provides an endpoint for transferring money between two bank accounts.
 */
@RestController
@RequestMapping("/transfer")
public class TransferController {

    private MoneyTransferService moneyTransferService;
    
    @Autowired
    public TransferController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    /**
     * Transfers money from one bank account to another.
     * 
     * @param request The transfer request containing information about the source
     *                and destination accounts
     *                and the amount to transfer.
     * @return A ResponseEntity containing a message indicating whether the transfer
     *         was successful or an error
     *         message if the transfer could not be completed.
     */
    
    @PostMapping
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest request) {
        try {
            moneyTransferService.transferMoney(request.getFromAccountId(), request.getToAccountId(),
                    request.getAmount());
            return new ResponseEntity<>("Money transfer successful", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }    
    
}
