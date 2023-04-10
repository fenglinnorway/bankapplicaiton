package com.bank.transation.demo.model.dto;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {
    private String fromAccountId;
    private String toAccountId;
    private int amount;

}
