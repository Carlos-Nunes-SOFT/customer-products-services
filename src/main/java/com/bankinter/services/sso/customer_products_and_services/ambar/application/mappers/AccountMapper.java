package com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input.CreateAccountDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.AccountDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.AccountDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AccountMapper {

    private final BalanceMapper balanceMapper;
    private final CardMapper cardMapper;

    public AccountMapper(BalanceMapper balanceMapper, CardMapper cardMapper) {
        this.balanceMapper = balanceMapper;
        this.cardMapper = cardMapper;
    }

   public AccountDto toDto(Account account){
        if(account==null)
            return null;
        return new AccountDto(account.getId(), account.getCustomerId(), account.getBaseCurrency(), account.getType(), account.getNib(), account.getStatus(), account.getSubProductId(),
                account.getIdentification(), account.getAccountActivityStatus(), account.getIsCurrent(), account.getPropertyStatus());
    }

    public AccountDetailsDto toDetailedDto(Account account){
        if(account==null)
            return null;
        return new AccountDetailsDto(account.getId(), account.getCustomerId(), account.getBaseCurrency(), account.getType(), account.getNib(), account.getStatus(),
                account.getSubProductId(), account.getIdentification(), account.getAccountActivityStatus(), balanceMapper.toDtoList(account.getBalances()),
                new ArrayList<>(), account.getIsCurrent(),account.getPropertyStatus());
    }
}
