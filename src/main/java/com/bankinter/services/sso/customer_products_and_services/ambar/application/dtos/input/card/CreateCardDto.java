package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input.card;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import jakarta.annotation.Nullable;

public class CreateCardDto {

    private String accountNumber;

    private String cardNumber;

    private String cardType;

    private String nameInCard;

    private Long productId;

    private Long subProductId;

    private PropertyStatus propertyStatus;

    public CreateCardDto(String accountNumber, String cardNumber, String cardType, String nameInCard,
                         Long productId, Long subProductId, PropertyStatus propertyStatus) {
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.nameInCard = nameInCard;
        this.productId = productId;
        this.subProductId = subProductId;
        this.propertyStatus = propertyStatus;
    }
}
