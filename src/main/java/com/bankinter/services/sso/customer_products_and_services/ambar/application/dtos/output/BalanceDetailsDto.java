package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceIndicator;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceType;

import java.math.BigDecimal;

public class BalanceDetailsDto {
    private Long id;

    //private Long accountId; //foreign key

    private BalanceType type;

    private BalanceIndicator creditDebitIndicator;

    private String calculationDate;

    private BigDecimal balanceAmount;

    public BalanceDetailsDto(Long id, BalanceType type, BalanceIndicator creditDebitIndicator,
                             String calculationDate, BigDecimal balanceAmount) {
        this.id = id;
        this.type = type;
        this.creditDebitIndicator = creditDebitIndicator;
        this.calculationDate = calculationDate;
        this.balanceAmount = balanceAmount;
    }

    public Long getId() {
        return id;
    }

    public String getCalculationDate() {
        return calculationDate;
    }

    public BalanceIndicator getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public BalanceType getType() {
        return type;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }
}
