package com.bank.transation.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.transation.demo.model.bank.MoneyTransferEvent;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface TransitionRepository extends JpaRepository<MoneyTransferEvent, String>{
    @Query("SELECT a FROM MoneyTransferEvent a WHERE a.accountId = :accountId")
    public List<MoneyTransferEvent> getMiniStatement(String accountId);

}
