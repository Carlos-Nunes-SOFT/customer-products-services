package com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.balance.BalanceDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Balance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BalanceMapper {
    public BalanceDetailsDto toDto(Balance balance) {
        if(balance==null)
            return null;
        return new BalanceDetailsDto(balance.getId(), balance.getAccountId(), balance.getType(), balance.getCreditDebitIndicator(),
                balance.getCalculationDate(), balance.getBalanceAmount());
    }

    public List<BalanceDetailsDto> toDtoList(List<Balance> balances){
        return balances.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
