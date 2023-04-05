package com.bank.transation.demo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import com.bank.transation.demo.model.bank.Account;
import com.bank.transation.demo.model.bank.MoneyTransferEvent;
import com.bank.transation.demo.model.bank.TransactionType;

public class UtilityHelper {

	private UtilityHelper() {
	}

	public static Supplier<List<Account>> accountSupplier = () -> Arrays.asList(
			Account.builder().accountId("QR8372915628").currency("gbp").balance(10000).build(),
			Account.builder().accountId("QR8372915628").currency("gbp").balance(20000).build(),
			Account.builder().accountId("LA1023846570").currency("gbp").balance(30000).build(),
			Account.builder().accountId("DK5896472301").currency("gbp").balance(40000).build(),
			Account.builder().accountId("XM9485720136").currency("gbp").balance(50000).build(),
			Account.builder().accountId("CP1294857630").currency("gbp").balance(60000).build());

	public static Supplier<List<MoneyTransferEvent>> moneyTransferEventSupplier = () -> {
		List<MoneyTransferEvent> events = new ArrayList<>(Arrays.asList(
				MoneyTransferEvent.builder().accountId("AB1234567890").amount(100).currency("gbp")
						.transitionType(TransactionType.TYPE.CREDIT.name()).transactionDate(
								java.sql.Date.valueOf(java.time.LocalDate.now()))
						.build(),
				MoneyTransferEvent.builder().accountId("CP1294857630").amount(100).currency("gbp").transitionType(
						TransactionType.TYPE.CREDIT.name()).transactionDate(
								java.sql.Date.valueOf(java.time.LocalDate
										.now()))
						.build(),
				MoneyTransferEvent.builder().accountId("HZ7351968402").amount(100).currency("gbp").transitionType(
						TransactionType.TYPE.CREDIT.name()).transactionDate(
								java.sql.Date.valueOf(java.time.LocalDate
										.now()))
						.build(),
				MoneyTransferEvent.builder().accountId("XM9485720136").amount(100).currency("gbp").transitionType(
						TransactionType.TYPE.CREDIT.name()).transactionDate(
								java.sql.Date.valueOf(java.time.LocalDate
										.now()))
						.build(),
				MoneyTransferEvent.builder().accountId("DK5896472301").amount(100).currency("gbp").transitionType(
						TransactionType.TYPE.CREDIT.name()).transactionDate(
								java.sql.Date.valueOf(java.time.LocalDate.now()))
						.build(),
				MoneyTransferEvent.builder().accountId("LA1023846570").amount(100).currency("gbp").transitionType(
						TransactionType.TYPE.CREDIT.name()).transactionDate(
								java.sql.Date.valueOf(java.time.LocalDate.now()))
						.build()));

		IntStream.range(0, 20).forEach(i -> {
			MoneyTransferEvent event = MoneyTransferEvent.builder()
					.accountId("CP1294857630")
					.amount(100)
					.currency("gbp")
					.transitionType(TransactionType.TYPE.CREDIT.name())
					.transactionDate(java.sql.Date.valueOf(java.time.LocalDate.now()))
					.build();
			events.add(event);
		});

		return events;
	};
}
