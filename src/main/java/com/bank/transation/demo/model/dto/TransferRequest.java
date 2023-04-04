package com.bank.transation.demo.model.dto;

import lombok.*;


@Getter
@Setter
@Builder
public class TransferRequest {
    private String fromAccountId;
    private String toAccountId;
    private int amount;

}
