package com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.balance;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.BalanceDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.services.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceCommandHandler {

    private final BalanceService balanceService;

    public BalanceCommandHandler(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    public BalanceDetailsDto createBalance(CreateBalanceCommand request){
        return this.balanceService.createBalance(request);
    }
}
