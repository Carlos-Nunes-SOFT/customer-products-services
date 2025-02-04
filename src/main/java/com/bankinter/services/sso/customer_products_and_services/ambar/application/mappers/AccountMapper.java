package com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input.CreateAccountDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.AccountDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    private final BalanceMapper balanceMapper;
    private final CardMapper cardMapper;

    public AccountMapper(BalanceMapper balanceMapper, CardMapper cardMapper) {
        this.balanceMapper = balanceMapper;
        this.cardMapper = cardMapper;
    }

    public Account toEntity(CreateAccountDto dto){
        if(dto==null)
            return null;
        return new Account(dto.getCustomerId(), dto.getBaseCurrency(), dto.getType(), dto.getNib(), dto.getStatus(), dto.getSubProductId(),
                dto.getIdentification(), dto.getAccountActivityStatus(), dto.getIsCurrent(), dto.getPropertyStatus());
    }

    public AccountDetailsDto toDetailedDto(Account account){
        if(account==null)
            return null;
        return new AccountDetailsDto(account.getId(), account.getCustomerId(), account.getBaseCurrency(), account.getType(), account.getNib(), account.getStatus(),
                account.getSubProductId(), account.getIdentification(), account.getAccountActivityStatus(), balanceMapper.toDtoList(account.getBalances()),
                cardMapper.toDtoList(account.getCards()), account.isCurrent(),account.getPropertyStatus());
    }
}
