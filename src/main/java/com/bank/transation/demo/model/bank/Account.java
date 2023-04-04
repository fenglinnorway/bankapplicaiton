
package com.bank.transation.demo.model.bank;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Account {

    @Id
    @GeneratedValue
    private int id;
    private String accountId;
    private Integer balance;
    private String currency;

}
