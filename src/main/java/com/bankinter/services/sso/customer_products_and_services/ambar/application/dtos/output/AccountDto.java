package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;

public class AccountDto {
    private String id;

    private String customerId;

    private String baseCurrency;

    private String type;

    private String nib;

    private AccountStatus status;

    private String subProductId;

    private AccountIdentification identification;

    private AccountActivityStatus accountActivityStatus;

    private boolean isCurrent;

    private PropertyStatus propertyStatus;

    public AccountDto(String id, String customerId, String baseCurrency, String type, String nib, AccountStatus status,
                      String subProductId, AccountIdentification identification, AccountActivityStatus accountActivityStatus,
                      boolean isCurrent, PropertyStatus propertyStatus) {
        this.id = id;
        this.customerId = customerId;
        this.baseCurrency = baseCurrency;
        this.type = type;
        this.nib = nib;
        this.status = status;
        this.subProductId = subProductId;
        this.identification = identification;
        this.accountActivityStatus = accountActivityStatus;
        this.isCurrent = isCurrent;
        this.propertyStatus = propertyStatus;
    }

    public PropertyStatus getPropertyStatus() {
        return propertyStatus;
    }

    public String getSubProductId() {
        return subProductId;
    }

    public AccountActivityStatus getAccountActivityStatus() {
        return accountActivityStatus;
    }

    public AccountIdentification getIdentification() {
        return identification;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public String getNib() {
        return nib;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }
}
