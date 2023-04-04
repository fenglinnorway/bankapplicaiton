package com.bank.transation.demo.model.bank;


import lombok.*;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class MoneyTransferEvent {

    @Id
    @GeneratedValue
    private int id;
    private String accountId;
    private Integer amount;
    private String currency;
    private String transitionType;
    private Date transactionDate;

}
