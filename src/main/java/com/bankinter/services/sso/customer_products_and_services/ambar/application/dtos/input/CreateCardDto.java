package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;

public class CreateCardDto {

    private String accountId;

    private String cardNumber;

    private String cardType;

    private String nameInCard;

    private Long productId;

    private Long subProductId;

    private PropertyStatus propertyStatus;

    public CreateCardDto(String accountId, String cardNumber, String cardType, String nameInCard,
                         Long productId, Long subProductId, PropertyStatus propertyStatus) {
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.nameInCard = nameInCard;
        this.productId = productId;
        this.subProductId = subProductId;
        this.propertyStatus = propertyStatus;
    }
}
