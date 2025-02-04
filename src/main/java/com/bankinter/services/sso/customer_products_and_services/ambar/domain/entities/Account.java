package com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection = "accounts")
public class Account {

    @Id
    private String id;

    private String customerId; //Add customer reference

    private String baseCurrency;

    private String type;

    private String nib;

    private AccountStatus status;

    private String subProductId;

    private AccountIdentification identification;

    private AccountActivityStatus accountActivityStatus;

    private boolean isCurrent;

    private PropertyStatus propertyStatus;

    private final List<Balance> balances = new ArrayList<>();

    private List<String> cardIds = new ArrayList<>();

    protected Account(){}

    public Account(String customerId, String baseCurrency, String type, String nib, AccountStatus status,
                   String subProductId, AccountIdentification identification,
                   AccountActivityStatus accountActivityStatus, boolean isCurrent, PropertyStatus propertyStatus) {
        this.customerId = customerId;
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
        //balance.setAccountId(this.id);
    }

    public void removeBalance(Balance balance){
        if(balance==null)
            throw new IllegalArgumentException("Balance cannot be null.");
        this.balances.remove(balance);
    }

    public void addCard(String cardId){
        if(cardId == null)
            throw new IllegalArgumentException("Card id cannot be null.");
        this.cardIds.add(cardId);
    }

    public void removeCard(String cardId){
        if(cardId==null)
            throw new IllegalArgumentException("Card id cannot be null.");
        this.cardIds.remove(cardId);
    }

    public List<String> getCardIds() {
        return cardIds;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getId() {
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

    public String getSubProductId() {
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

    public boolean getIsCurrent() {
        return isCurrent;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setCardId(String customerId) {
        this.customerId = customerId;
    }

    public void setId(String id) {
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

    public void setSubProductId(String subProductId) {
        this.subProductId = subProductId;
    }
}
