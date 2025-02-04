package com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId; //foreign key

    //private String accountNumber; DEPRECATED

    private String cardNumber;

    private String cardType;

    private String nameInCard;

    private Long productId;

    private Long subProductId;

    @Nullable
    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;

    protected Card(){}

    public Card(Long accountId, PropertyStatus propertyStatus, Long subProductId, Long productId, String nameInCard, String cardType, String cardNumber) {
        this.accountId = accountId;
        this.propertyStatus = propertyStatus;
        this.subProductId = subProductId;
        this.productId = productId;
        this.nameInCard = nameInCard;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Nullable
    public PropertyStatus getPropertyStatus() {
        return propertyStatus;
    }

    public Long getSubProductId() {
        return subProductId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getNameInCard() {
        return nameInCard;
    }
}
