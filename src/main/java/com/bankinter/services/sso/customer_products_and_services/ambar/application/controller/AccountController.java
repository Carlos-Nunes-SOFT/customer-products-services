package com.bankinter.services.sso.customer_products_and_services.ambar.application.controller;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.account.AccountCommandHandler;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.account.CreateAccountCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.account.AccountDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.services.account.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Validated
@Tag(name = "accounts", description = "the accounts API")
@RequestMapping("/api/v1/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private final AccountCommandHandler accountCommandHandler;

    public AccountController(AccountCommandHandler accountCommandHandler) {
        this.accountCommandHandler = accountCommandHandler;
    }

    @PostMapping
    public ResponseEntity<AccountDetailsDto> createAccount(@Valid @RequestBody CreateAccountCommand request){
        AccountDetailsDto accountDetailsDto = this.accountCommandHandler.createAccount(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(accountDetailsDto.getId().toString())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
