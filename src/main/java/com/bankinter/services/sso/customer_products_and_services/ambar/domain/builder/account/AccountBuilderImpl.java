package com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.account;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Balance;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Card;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;
import org.springframework.stereotype.Component;

@Component
public class AccountBuilderImpl implements AccountBuilder {
    private Account account;

    @Override
    public Account build() {
        if(account==null)
            throw new IllegalArgumentException("The account object is not initialized.");
        return account;
    }

    @Override
    public AccountBuilder newAccount(String customerId, String baseCurrency, String type, String nib,
                             AccountStatus status, String subProductId, AccountIdentification identification,
                                     AccountActivityStatus accountActivityStatus, boolean isCurrent, PropertyStatus propertyStatus) {
        account = new Account(customerId, baseCurrency, type, nib, status,
                subProductId, identification, accountActivityStatus, isCurrent, propertyStatus);
        return this;
    }

    @Override
    public AccountBuilder addBalance(Balance balance) {
        if(balance == null)
            throw new IllegalArgumentException("The balance object cannot be null.");
        account.addBalance(balance);
        return this;
    }

    @Override
    public AccountBuilder addCard(String cardId) {
        if(cardId==null)
            throw new IllegalArgumentException("The card object cannot be null.");
        account.addCard(cardId);
        return this;
    }
}
