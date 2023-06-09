
package com.bank.transation.demo.model.bank;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
@ToString
public class Account {

    @Id
    @GeneratedValue
    private int id;
    private String accountId;
    private Integer balance;
    private String currency;
    @Version
    private Long version;
}
