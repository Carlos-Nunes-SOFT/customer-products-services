package com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceIndicator;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceType;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "balances")
public class Balance {

    @Id
    private String id;

    private BalanceType type;

    private BalanceIndicator creditDebitIndicator;

    private String calculationDate;

    private BigDecimal balanceAmount;

    protected Balance(){}

    public Balance(BalanceType type, BalanceIndicator creditDebitIndicator, String calculationDate, BigDecimal balanceAmount) {
        this.type = type;
        this.creditDebitIndicator = creditDebitIndicator;
        this.calculationDate = calculationDate;
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public BalanceType getType() {
        return type;
    }

    public BalanceIndicator getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public String getCalculationDate() {
        return calculationDate;
    }

    public String getId() {
        return id;
    }

    public void setCalculationDate(String calculationDate) {
        this.calculationDate = calculationDate;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public void setCreditDebitIndicator(BalanceIndicator creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public void setType(BalanceType type) {
        this.type = type;
    }

}
