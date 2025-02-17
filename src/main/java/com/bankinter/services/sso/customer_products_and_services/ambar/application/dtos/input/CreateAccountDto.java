package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;

public class CreateAccountDto {

    private String customerId;

    private String baseCurrency;

    private String type;

    private String nib;

    private AccountStatus status;

    private Long subProductId;

    private AccountIdentification identification;

    private AccountActivityStatus accountActivityStatus;

    private boolean isCurrent;

    private PropertyStatus propertyStatus;

    public CreateAccountDto(String customerId, String baseCurrency, String type, String nib, AccountStatus status, Long subProductId,
                            AccountIdentification identification, AccountActivityStatus accountActivityStatus,
                            boolean isCurrent, PropertyStatus propertyStatus) {
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

    public String getCustomerId() {
        return customerId;
    }

    public Long getSubProductId() {
        return subProductId;
    }

    public PropertyStatus getPropertyStatus() {
        return propertyStatus;
    }

    public String getType() {
        return type;
    }

    public String getNib() {
        return nib;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public AccountActivityStatus getAccountActivityStatus() {
        return accountActivityStatus;
    }

    public AccountIdentification getIdentification() {
        return identification;
    }

    public boolean getIsCurrent() {
        return isCurrent;
    }

}
