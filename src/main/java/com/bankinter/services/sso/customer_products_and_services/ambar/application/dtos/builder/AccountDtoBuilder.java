package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.builder;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input.account.CreateAccountDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input.balance.CreateBalanceDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;

public interface AccountDtoBuilder {
    CreateAccountDto build();
    AccountDtoBuilder newAccountDto(Long cardId, String baseCurrency, String type, String nib, AccountStatus status, Long subProductId,
                                    AccountIdentification identification, AccountActivityStatus accountActivityStatus,
                                    boolean isCurrent, PropertyStatus propertyStatus);
    //AccountDtoBuilder addBalance(CreateBalanceDto balance);
}
