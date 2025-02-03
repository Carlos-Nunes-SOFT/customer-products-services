package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.card;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import jakarta.annotation.Nullable;

public class CardDetailsDto {
    private Long id;

    private String accountNumber;

    private String cardNumber;

    private String cardType;

    private String nameInCard;

    private Long productId;

    private Long subProductId;

    private PropertyStatus propertyStatus;

    public CardDetailsDto(Long id, String accountNumber, String cardNumber, String cardType, String nameInCard,
                          Long productId, Long subProductId, PropertyStatus propertyStatus) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.nameInCard = nameInCard;
        this.productId = productId;
        this.subProductId = subProductId;
        this.propertyStatus = propertyStatus;
    }
}
