package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.builder;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input.account.CreateAccountDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input.balance.CreateBalanceDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoBuilderImpl implements AccountDtoBuilder{

    private CreateAccountDto createAccountDto;

    @Override
    public CreateAccountDto build() {
        if(createAccountDto==null)
            throw new IllegalArgumentException("The account object is not initialized.");
        return createAccountDto;
    }

    @Override
    public AccountDtoBuilder newAccountDto(Long cardId, String baseCurrency, String type, String nib, AccountStatus status, Long subProductId,
                                           AccountIdentification identification, AccountActivityStatus accountActivityStatus, boolean isCurrent,
                                           PropertyStatus propertyStatus) {
        createAccountDto = new CreateAccountDto(cardId, baseCurrency, type, nib, status, subProductId,
                identification, accountActivityStatus, isCurrent,propertyStatus);
        return this;
    }

}
