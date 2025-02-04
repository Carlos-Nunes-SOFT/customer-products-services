package com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.account;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.AccountDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.AccountDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.CardDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.exceptions.NotFoundException;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.AccountMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.CardMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.AccountRepository;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountQueryHandler {
    private AccountRepository accountRepository;
    private AccountMapper accountMapper;
    private CardRepository cardRepository;
    private CardMapper cardMapper;

    public AccountQueryHandler(AccountRepository accountRepository, AccountMapper accountMapper,
                               CardRepository cardRepository, CardMapper cardMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    public AccountDetailsDto getById(GetAccountByIdQuery request){
        Account account = this.accountRepository.findById(request.id)
                .orElseThrow(() -> new NotFoundException("No such account with id: " + request.id));

        List<CardDetailsDto> cards = this.cardRepository.findAllById(account.getCardIds())
                .stream()
                .map(cardMapper::toDto)
                .collect(Collectors.toList());

        return new AccountDetailsDto(account.getId(), account.getCustomerId(), account.getBaseCurrency(), account.getType(),
                account.getNib(), account.getStatus(), account.getSubProductId(), account.getIdentification(),
                account.getAccountActivityStatus(), new ArrayList<>(), cards, account.getIsCurrent(), account.getPropertyStatus());
    }

    public List<AccountDto> getAccounts(){
        return this.accountRepository.findAll().stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CardDetailsDto> getAccountCards(GetAccountCardsByAccountIdQuery request){
        Account account = this.accountRepository.findById(request.accountId)
                .orElseThrow(() -> new NotFoundException("No such account with id: " + request.accountId));

        return cardRepository.findAllById(account.getCardIds()).stream()
                .map(cardMapper::toDto)
                .collect(Collectors.toList());
    }

}
