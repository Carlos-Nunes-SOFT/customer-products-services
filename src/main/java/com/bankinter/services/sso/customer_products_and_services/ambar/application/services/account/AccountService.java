package com.bankinter.services.sso.customer_products_and_services.ambar.application.services.account;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.account.CreateAccountCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.account.AccountDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.AccountMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.account.AccountBuilder;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AccountRepository accountRepository;
    private final AccountBuilder accountBuilder;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountBuilder accountBuilder, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountBuilder = accountBuilder;
        this.accountMapper = accountMapper;
    }

    public AccountDetailsDto createAccount(CreateAccountCommand request){

        Account account = this.accountBuilder
                .newAccount(request.cardId, request.baseCurrency, request.type, request.nib, request.status,
                                request.subProductId, request.identification, request.accountActivityStatus,
                                    request.isCurrent, request.propertyStatus)
                .build();

        this.accountRepository.save(account);

        return this.accountMapper.toDetailedDto(account);
    }
}
