package com.bankinter.services.sso.customer_products_and_services.ambar.domain.services;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.balance.CreateBalanceCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.BalanceDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.exceptions.NotFoundException;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.BalanceMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.balance.BalanceBuilder;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Balance;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.AccountRepository;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.BalanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalanceService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AccountRepository accountRepository;
    private final BalanceRepository balanceRepository;
    private final BalanceBuilder balanceBuilder;
    private final BalanceMapper balanceMapper;

    public BalanceService(AccountRepository accountRepository, BalanceRepository balanceRepository, BalanceBuilder balanceBuilder, BalanceMapper balanceMapper) {
        this.accountRepository = accountRepository;
        this.balanceRepository = balanceRepository;
        this.balanceBuilder = balanceBuilder;
        this.balanceMapper = balanceMapper;
    }

    @Transactional
    public BalanceDetailsDto createBalance(CreateBalanceCommand request){
        Account account = this.accountRepository.findById(request.accountId)
                .orElseThrow(() -> new NotFoundException("No such account with id: " + request.accountId));

        Balance balance = this.balanceBuilder
                .newBalance(request.type, request.creditDebitIndicator, request.calculationDate, request.balanceAmount)
                .build();

        this.balanceRepository.save(balance);

        account.addBalance(balance);
        this.accountRepository.save(account);

        return this.balanceMapper.toDto(balance);
    }
}
