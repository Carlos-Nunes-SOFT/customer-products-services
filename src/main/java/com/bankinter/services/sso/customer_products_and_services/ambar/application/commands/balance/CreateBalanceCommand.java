package com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.balance;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceIndicator;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceType;

import java.math.BigDecimal;

public class CreateBalanceCommand {
    public String accountId;

    public BalanceType type;

    public BalanceIndicator creditDebitIndicator;

    public String calculationDate;

    public BigDecimal balanceAmount;
}
