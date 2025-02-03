package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.account;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.balance.BalanceDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.PropertyStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountActivityStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.enums.account.AccountStatus;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects.AccountIdentification;

import java.util.List;

public class AccountDetailsDto {
    private Long id;

    private String baseCurrency;

    private String type;

    private String nib;

    private AccountStatus status;

    private Long subProductId;

    private AccountIdentification identification;

    private AccountActivityStatus accountActivityStatus;

    private List<BalanceDetailsDto> balances;

    private boolean isCurrent;

    private PropertyStatus propertyStatus;

    public AccountDetailsDto(Long id, String baseCurrency, String type, String nib, AccountStatus status, Long subProductId,
                             AccountIdentification identification, AccountActivityStatus accountActivityStatus,
                             List<BalanceDetailsDto> balances, boolean isCurrent, PropertyStatus propertyStatus) {
        this.id = id;
        this.baseCurrency = baseCurrency;
        this.type = type;
        this.nib = nib;
        this.status = status;
        this.subProductId = subProductId;
        this.identification = identification;
        this.accountActivityStatus = accountActivityStatus;
        this.balances = balances;
        this.isCurrent = isCurrent;
        this.propertyStatus = propertyStatus;
    }

    public Long getId() {
        return id;
    }
}
