package com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cardId; //Add card reference

    private String baseCurrency;

    private String type;

    private String nib;

    private AccountStatus status;

    private Long subProductId;

    private AccountIdentification identification;

    private AccountActivityStatus accountActivityStatus;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @Transient //not stored on this database
    private final List<Balance> balances = new ArrayList<>();

    private boolean isCurrent;

    //make it nullable
    @Nullable
    private PropertyStatus propertyStatus;

    protected Account(){}

    public Account(Long cardId, String baseCurrency, String type, String nib, AccountStatus status,
                   Long subProductId, AccountIdentification identification,
                   AccountActivityStatus accountActivityStatus, boolean isCurrent, PropertyStatus propertyStatus) {
        this.cardId = cardId;
        this.baseCurrency = baseCurrency;
        this.type = type;
        this.nib = nib;
        this.status = status;
        this.subProductId = subProductId;
        this.identification = identification;
        this.accountActivityStatus = accountActivityStatus;
        this.isCurrent = isCurrent;
        this.propertyStatus = propertyStatus;
    }

    public void addBalance(Balance balance){
        if(balance == null)
            throw new IllegalArgumentException("Balance cannot be null.");
        this.balances.add(balance);
        balance.setAccountId(this.id);
    }

    public void removeBalance(Balance balance){
        if(balance==null)
            throw new IllegalArgumentException("Balance cannot be null.");
        this.balances.remove(balance);
    }

    public Long getCardId() {
        return cardId;
    }

    public Long getId() {
        return id;
    }

    public AccountIdentification getIdentification() {
        return identification;
    }

    public AccountActivityStatus getAccountActivityStatus() {
        return accountActivityStatus;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public List<Balance> getBalances() {
        return Collections.unmodifiableList(balances);
    }

    public Long getSubProductId() {
        return subProductId;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getNib() {
        return nib;
    }

    public String getType() {
        return type;
    }

    public PropertyStatus getPropertyStatus() {
        return propertyStatus;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccountActivityStatus(AccountActivityStatus accountActivityStatus) {
        this.accountActivityStatus = accountActivityStatus;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public void setIdentification(AccountIdentification identification) {
        this.identification = identification;
    }

    public void setNib(String nib) {
        this.nib = nib;
    }

    public void setPropertyStatus(PropertyStatus propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public void setSubProductId(Long subProductId) {
        this.subProductId = subProductId;
    }
}
