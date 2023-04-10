package com.bank.transation.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.bank.transation.demo.model.bank.Account;
import com.bank.transation.demo.model.bank.MoneyTransferEvent;
import com.bank.transation.demo.repository.AccountRepository;
import com.bank.transation.demo.repository.TransitionRepository;
import com.bank.transation.demo.utils.UtilityHelper;

import java.util.List;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}



	@Autowired
	private TransitionRepository transitionRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Bean
	@Profile("integration")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	// @Bean
	// @Profile("unit")
	// CommandLineRunner runner() {
	// 	return args -> {

	// 		List<Account> accounts = accountRepository.findAll();

			
	// 		if(accounts.isEmpty()) {
	// 			log.info("******* Inserting Accounts to DB *******");
	// 			accountRepository.saveAll(UtilityHelper.accountSupplier.get());
	// 		} else {
	// 			log.info("******* Accounts stored in DB Size :: {}", accounts.size());
	// 			log.info("******* Accounts stored in DB :: {}", accounts);
	// 		} 
	// 		List<MoneyTransferEvent> transferEvents = transitionRepository.findAll();
	// 		if (transferEvents.isEmpty()) {
	// 			log.info("******* Inserting MoneyTransferEvents to DB *******");
	// 			transitionRepository.saveAll(UtilityHelper.moneyTransferEventSupplier.get());
	// 		} else {
	// 			log.info("******* MoneyTransferEvents stored in DB Size :: {}", transferEvents.size());
	// 			log.info("******* MoneyTransferEvents stored in DB :: {}", transferEvents);
	// 		}
	// 	};
	//}

}
