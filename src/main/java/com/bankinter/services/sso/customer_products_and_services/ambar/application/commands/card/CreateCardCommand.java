package com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.card;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;

public class CreateCardCommand {
    public String accountId;

    public String cardNumber;

    public String cardType;

    public String nameInCard;

    public Long productId;

    public Long subProductId;

    public PropertyStatus propertyStatus;
}
