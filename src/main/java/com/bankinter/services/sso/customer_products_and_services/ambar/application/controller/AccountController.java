package com.bankinter.services.sso.customer_products_and_services.ambar.application.controller;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.account.AccountCommandHandler;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.account.CreateAccountCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.AccountDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.AccountDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.CardDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.account.AccountQueryHandler;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.account.GetAccountByIdQuery;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.account.GetAccountCardsByAccountIdQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Validated
@Tag(name = "accounts", description = "the accounts API")
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountCommandHandler accountCommandHandler;
    private final AccountQueryHandler accountQueryHandler;

    public AccountController(AccountCommandHandler accountCommandHandler,
                             AccountQueryHandler accountQueryHandler) {
        this.accountCommandHandler = accountCommandHandler;
        this.accountQueryHandler = accountQueryHandler;
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

    @GetMapping("/accounts")
    ResponseEntity<List<AccountDto>> getAccounts(){
        List<AccountDto> accounts = this.accountQueryHandler.getAccounts();

        return ResponseEntity.ok(accounts);
    }

    @GetMapping
    public ResponseEntity<AccountDetailsDto> getAccountById(@RequestParam(name = "id") Long accountId){
        GetAccountByIdQuery request = new GetAccountByIdQuery(accountId);
        AccountDetailsDto account = this.accountQueryHandler.getById(request);

        return ResponseEntity.ok(account);
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardDetailsDto>> getAccountCards(@RequestParam(name = "id") Long accountId){
        GetAccountCardsByAccountIdQuery request = new GetAccountCardsByAccountIdQuery(accountId);
        List<CardDetailsDto> cards = this.accountQueryHandler.getAccountCards(request);

        return ResponseEntity.ok(cards);
    }

}
