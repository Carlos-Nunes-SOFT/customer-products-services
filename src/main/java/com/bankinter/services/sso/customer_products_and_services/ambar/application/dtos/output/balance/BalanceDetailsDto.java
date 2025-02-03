package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.balance;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceIndicator;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceType;

import java.math.BigDecimal;

public class BalanceDetailsDto {
    private Long id;

    private Long accountId; //foreign key

    private BalanceType type;

    private BalanceIndicator creditDebitIndicator;

    private String calculationDate;

    private BigDecimal balanceAmount;

    public BalanceDetailsDto(Long id, Long accountId, BalanceType type, BalanceIndicator creditDebitIndicator,
                             String calculationDate, BigDecimal balanceAmount) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.creditDebitIndicator = creditDebitIndicator;
        this.calculationDate = calculationDate;
        this.balanceAmount = balanceAmount;
    }
}
