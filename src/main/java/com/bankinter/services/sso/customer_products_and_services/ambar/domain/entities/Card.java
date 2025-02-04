package com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cards")
public class Card {

    @Id
    private String id;

    private String cardNumber;

    private String cardType;

    private String nameInCard;

    private Long productId;

    private Long subProductId;

    private PropertyStatus propertyStatus;

    protected Card(){}

    public Card(PropertyStatus propertyStatus, Long subProductId, Long productId, String nameInCard, String cardType, String cardNumber) {
        this.propertyStatus = propertyStatus;
        this.subProductId = subProductId;
        this.productId = productId;
        this.nameInCard = nameInCard;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public String getId() {
        return id;
    }

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
