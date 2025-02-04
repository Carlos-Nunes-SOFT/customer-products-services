package com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.account;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.AccountDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountCommandHandler {

    private final AccountService accountService;

    public AccountCommandHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountDetailsDto createAccount(CreateAccountCommand request){
        return this.accountService.createAccount(request);
    }
}
