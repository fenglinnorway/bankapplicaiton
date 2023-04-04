package com.bank.transation.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.transation.demo.model.bank.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {


    @Query("SELECT a FROM Account a WHERE a.accountId = :accountId")
    public Account findByAccountId(String accountId);
    
}
