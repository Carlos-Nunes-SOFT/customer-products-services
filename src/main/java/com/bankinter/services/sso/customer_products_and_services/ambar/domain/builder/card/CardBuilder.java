package com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.card;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Card;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;

public interface CardBuilder {
    Card build();
    CardBuilder newCard(Long accountId, PropertyStatus propertyStatus, Long subProductId, Long productId, String nameInCard, String cardType, String cardNumber);
}
