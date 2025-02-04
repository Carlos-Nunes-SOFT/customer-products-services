package com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.account;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;

public class CreateAccountCommand {
    public String customerId;

    public String baseCurrency;

    public String type;

    public String nib;

    public AccountStatus status;

    public String subProductId;

    public AccountIdentification identification;

    public AccountActivityStatus accountActivityStatus;

    public boolean isCurrent;

    public PropertyStatus propertyStatus;
}
