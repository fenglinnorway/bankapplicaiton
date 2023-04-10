package com.bank.transation.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Lock;
import javax.persistence.LockModeType;
import java.util.Optional;

import com.bank.transation.demo.model.bank.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT a FROM Account a WHERE a.accountId = :accountId")
    public Optional<Account> findByAccountId(String accountId);
    
}
