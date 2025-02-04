package com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.account;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.AccountDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.exceptions.NotFoundException;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.AccountMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountQueryHandler {
    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    public AccountQueryHandler(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public AccountDetailsDto getById(GetAccountByIdQuery request){
        return this.accountRepository.findById(request.id)
                .map(accountMapper::toDetailedDto)
                .orElseThrow(() -> new NotFoundException("No such account with id: " + request.id));
    }

    public List<AccountDetailsDto> getAccounts(){
        return this.accountRepository.findAll().stream()
                .map(accountMapper::toDetailedDto)
                .collect(Collectors.toList());
    }
}
