package com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long accountId; //foreign key

    private String accountNumber;

    private String cardNumber;

    private String cardType;

    private String nameInCard;

    private Long productId;

    private Long subProductId;

    //make it nullable
    @Nullable
    private PropertyStatus propertyStatus;

    protected Card(){}

    public Card(PropertyStatus propertyStatus, Long subProductId, Long productId, String nameInCard, String cardType, String cardNumber, String accountNumber) {
        this.propertyStatus = propertyStatus;
        this.subProductId = subProductId;
        this.productId = productId;
        this.nameInCard = nameInCard;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
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

    public String getAccountNumber() {
        return accountNumber;
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
