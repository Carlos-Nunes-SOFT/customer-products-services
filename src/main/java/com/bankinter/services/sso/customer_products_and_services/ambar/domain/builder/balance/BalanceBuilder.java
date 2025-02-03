package com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.balance;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Balance;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceIndicator;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceType;

import java.math.BigDecimal;

public interface BalanceBuilder {
    Balance build();
    BalanceBuilder newBalance(Long accountId, BalanceType type, BalanceIndicator creditDebitIndicator,
                              String calculationDate, BigDecimal balanceAmount);
}
