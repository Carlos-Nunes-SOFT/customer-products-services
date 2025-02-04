package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;

public class CardDetailsDto {
    private Long id;

    //private Long accountId; NOT NECCESSARY

    //private String accountNumber; DEPRECATED

    private String cardNumber;

    private String cardType;

    private String nameInCard;

    private Long productId;

    private Long subProductId;

    private PropertyStatus propertyStatus;

    public CardDetailsDto(Long id, String cardNumber, String cardType, String nameInCard,
                          Long productId, Long subProductId, PropertyStatus propertyStatus) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.nameInCard = nameInCard;
        this.productId = productId;
        this.subProductId = subProductId;
        this.propertyStatus = propertyStatus;
    }

    public Long getId() {
        return id;
    }

    public PropertyStatus getPropertyStatus() {
        return propertyStatus;
    }

    public Long getSubProductId() {
        return subProductId;
    }

    public String getNameInCard() {
        return nameInCard;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Long getProductId() {
        return productId;
    }
}
