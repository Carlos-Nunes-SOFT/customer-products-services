package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;

import java.util.List;

public class AccountDto {
    private Long id;

    private Long customerId;

    private String baseCurrency;

    private String type;

    private String nib;

    private AccountStatus status;

    private Long subProductId;

    private AccountIdentification identification;

    private AccountActivityStatus accountActivityStatus;

    private boolean isCurrent;

    private PropertyStatus propertyStatus;

    public AccountDto(Long id, Long customerId, String baseCurrency, String type, String nib, AccountStatus status,
                      Long subProductId, AccountIdentification identification, AccountActivityStatus accountActivityStatus,
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

    public Long getSubProductId() {
        return subProductId;
    }

    public AccountActivityStatus getAccountActivityStatus() {
        return accountActivityStatus;
    }

    public AccountIdentification getIdentification() {
        return identification;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getId() {
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
