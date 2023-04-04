package com.bank.transation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.transation.demo.model.dto.TransferRequest;
import com.bank.transation.demo.service.MoneyTransferService;

import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/transfer")
public class TransferController {

    private MoneyTransferService moneyTransferService;
    
    @Autowired
    public TransferController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

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
