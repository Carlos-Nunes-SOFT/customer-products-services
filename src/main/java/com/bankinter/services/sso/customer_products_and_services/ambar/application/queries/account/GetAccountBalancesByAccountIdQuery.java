package com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.account;

public class GetAccountBalancesByAccountIdQuery {
    public String accountId;

    public GetAccountBalancesByAccountIdQuery(String accountId) {
        this.accountId = accountId;
    }
}
