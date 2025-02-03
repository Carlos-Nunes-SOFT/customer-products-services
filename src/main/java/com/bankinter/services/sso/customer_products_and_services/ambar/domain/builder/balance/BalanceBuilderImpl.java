package com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.balance;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Balance;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceIndicator;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceType;

import java.math.BigDecimal;

public class BalanceBuilderImpl implements  BalanceBuilder{

    private Balance balance;

    @Override
    public Balance build() {
        if(balance==null)
            throw new IllegalArgumentException("The balance object is not initialized.");
        return balance;
    }

    @Override
    public BalanceBuilder newBalance(Long accountId, BalanceType type, BalanceIndicator creditDebitIndicator, String calculationDate, BigDecimal balanceAmount) {
        balance = new Balance(accountId, type, creditDebitIndicator, calculationDate, balanceAmount);
        return this;
    }
}
