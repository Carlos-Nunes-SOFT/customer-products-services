package com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceIndicator;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.balance.BalanceType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId; //foreign key

    @Enumerated(EnumType.STRING)
    private BalanceType type;

    @Enumerated(EnumType.STRING)
    private BalanceIndicator creditDebitIndicator;

    private String calculationDate;

    private BigDecimal balanceAmount;

    protected Balance(){}

    public Balance(Long accountId, BalanceType type, BalanceIndicator creditDebitIndicator, String calculationDate, BigDecimal balanceAmount) {
        this.accountId = accountId;
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

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
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

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
