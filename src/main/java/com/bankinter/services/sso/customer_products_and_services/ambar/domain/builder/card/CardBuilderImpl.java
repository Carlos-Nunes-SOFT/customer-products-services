package com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.card;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Card;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import org.springframework.stereotype.Component;

@Component
public class CardBuilderImpl implements CardBuilder{
    private Card card;

    @Override
    public Card build() {
        if (card==null)
            throw new IllegalArgumentException("The card object is not initialized.");
        return card;
    }

    @Override
    public CardBuilder newCard(Long accountId, PropertyStatus propertyStatus, Long subProductId, Long productId,
                               String nameInCard, String cardType, String cardNumber) {
        card = new Card(accountId, propertyStatus, subProductId, productId, nameInCard, cardType, cardNumber);
        return this;
    }
}
