package com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.account;

public class GetAccountBalancesByAccountIdQuery {
    public Long accountId;

    public GetAccountBalancesByAccountIdQuery(Long accountId) {
        this.accountId = accountId;
    }
}
