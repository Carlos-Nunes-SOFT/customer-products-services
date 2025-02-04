package com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.account;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Balance;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Card;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;

public interface AccountBuilder {
    Account build();
    AccountBuilder newAccount(Long customerId, String baseCurrency, String type, String nib, AccountStatus status,
                          Long subProductId, AccountIdentification identification, AccountActivityStatus accountActivityStatus,
                              boolean isCurrent, PropertyStatus propertyStatus);
    AccountBuilder addBalance(Balance balance);
    AccountBuilder addCard(Long cardId);

}
