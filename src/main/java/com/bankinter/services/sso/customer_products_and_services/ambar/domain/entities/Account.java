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
//@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId; //Add customer reference

    private String baseCurrency;

    private String type;

    private String nib;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private Long subProductId;

    @Embedded
    private AccountIdentification identification;

    @Enumerated(EnumType.STRING)
    private AccountActivityStatus accountActivityStatus;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @Transient //not stored in this database
    private final List<Balance> balances = new ArrayList<>();

    //@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    //@Transient //not stored in this database
    //private final List<Card> cards = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "account_card_ids", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "card_id")
    private List<Long> cardIds = new ArrayList<>();

    private boolean isCurrent;

    @Nullable
    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;

    protected Account(){}

    public Account(Long customerId, String baseCurrency, String type, String nib, AccountStatus status,
                   Long subProductId, AccountIdentification identification,
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
        balance.setAccountId(this.id);
    }

    public void removeBalance(Balance balance){
        if(balance==null)
            throw new IllegalArgumentException("Balance cannot be null.");
        this.balances.remove(balance);
    }

    public void addCard(Long cardId){
        if(cardId == null)
            throw new IllegalArgumentException("Card id cannot be null.");
        this.cardIds.add(cardId);
    }

    public void removeCard(Long cardId){
        if(cardId==null)
            throw new IllegalArgumentException("Card id cannot be null.");
        this.cardIds.remove(cardId);
    }

    public List<Long> getCardIds() {
        return cardIds;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
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

    public boolean getIsCurrent() {
        return isCurrent;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setCardId(Long customerId) {
        this.customerId = customerId;
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
