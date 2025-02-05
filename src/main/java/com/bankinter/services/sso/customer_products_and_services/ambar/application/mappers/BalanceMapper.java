package com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.BalanceDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Balance;
import org.springframework.stereotype.Component;

@Component
public class BalanceMapper {
    public BalanceDetailsDto toDto(Balance balance) {
        if(balance==null)
            return null;
        return new BalanceDetailsDto(balance.getId(), balance.getType(), balance.getCreditDebitIndicator(),
                balance.getCalculationDate(), balance.getBalanceAmount());
    }
}
