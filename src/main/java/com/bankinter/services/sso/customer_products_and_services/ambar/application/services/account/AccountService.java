package com.bankinter.services.sso.customer_products_and_services.ambar.application.services.account;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.account.CreateAccountCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.builder.AccountDtoBuilder;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input.account.CreateAccountDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.account.AccountDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.AccountMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AccountRepository accountRepository;
    private final AccountDtoBuilder accountDtoBuilder;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountDtoBuilder accountDtoBuilder, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountDtoBuilder = accountDtoBuilder;
        this.accountMapper = accountMapper;
    }

    public AccountDetailsDto createAccount(CreateAccountCommand request){
        //Add logger info
        //Probably overcomplicated, maybe use builder annotation on dto? 
        CreateAccountDto accountDto = this.accountDtoBuilder
                .newAccountDto(request.cardId, request.baseCurrency, request.type, request.nib, request.status,
                                request.subProductId, request.identification, request.accountActivityStatus,
                                    request.isCurrent, request.propertyStatus)
                .build();

        Account entity = accountMapper.toEntity(accountDto);

        this.accountRepository.save(entity);

        AccountDetailsDto accountDetailsDto = accountMapper.toDetailedDto(entity);

        return accountDetailsDto;
    }
}
