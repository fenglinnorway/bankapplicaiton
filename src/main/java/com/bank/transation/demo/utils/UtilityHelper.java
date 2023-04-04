package com.bank.transation.demo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.bank.transation.demo.model.bank.Account;
import com.bank.transation.demo.model.bank.MoneyTransferEvent;
import com.bank.transation.demo.model.bank.TransactionType;

public class UtilityHelper {

    private UtilityHelper() {
    }

	public static Supplier<List<Account>> accountSupplier = () -> Arrays.asList(
			Account.builder().accountId("1").currency("gbp").balance(10000).build(),
			Account.builder().accountId("2").currency("gbp").balance(20000).build(),
			Account.builder().accountId("3").currency("gbp").balance(30000).build(),
			Account.builder().accountId("4").currency("gbp").balance(40000).build(),
			Account.builder().accountId("5").currency("gbp").balance(50000).build(),
			Account.builder().accountId("6").currency("gbp").balance(60000).build());

	public static Supplier<List<MoneyTransferEvent>> moneyTransferEventSupplier = () -> Arrays.asList(


		MoneyTransferEvent.builder().accountId("1").amount(100).currency("gbp").transitionType(TransactionType.TYPE.CREDIT.name()).transactionDate(
			java.sql.Date.valueOf(java.time.LocalDate.now())).build(),
		MoneyTransferEvent.builder().accountId("1").amount(100).currency("gbp").transitionType(
					TransactionType.TYPE.CREDIT.name()).transactionDate(
			java.sql.Date.valueOf(java.time.LocalDate
							.now())).build(),
		MoneyTransferEvent.builder().accountId("3").amount(100).currency("gbp").transitionType(
					TransactionType.TYPE.CREDIT.name()).transactionDate(
			java.sql.Date.valueOf(java.time.LocalDate		
							.now())).build(),
		MoneyTransferEvent.builder().accountId("4").amount(100).currency("gbp").transitionType(
					TransactionType.TYPE.CREDIT.name()).transactionDate(
			java.sql.Date.valueOf(java.time.LocalDate
							.now())).build(),
		MoneyTransferEvent.builder().accountId("5").amount(100).currency("gbp").transitionType(
					TransactionType.TYPE.CREDIT.name()).transactionDate(
			java.sql.Date.valueOf(java.time.LocalDate.now())).build(),
		MoneyTransferEvent.builder().accountId("6").amount(100).currency("gbp").transitionType(
					TransactionType.TYPE.CREDIT.name()).transactionDate(
			java.sql.Date.valueOf(java.time.LocalDate.now())).build());
}
