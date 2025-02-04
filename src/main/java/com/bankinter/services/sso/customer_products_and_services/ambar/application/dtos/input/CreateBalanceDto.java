package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceIndicator;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceType;

import java.math.BigDecimal;

public class CreateBalanceDto {

    private BalanceType type;

    private BalanceIndicator creditDebitIndicator;

    private String calculationDate;

    private BigDecimal balanceAmount;

    public CreateBalanceDto(BalanceType type, BalanceIndicator creditDebitIndicator, String calculationDate, BigDecimal balanceAmount) {
        this.type = type;
        this.creditDebitIndicator = creditDebitIndicator;
        this.calculationDate = calculationDate;
        this.balanceAmount = balanceAmount;
    }
}
