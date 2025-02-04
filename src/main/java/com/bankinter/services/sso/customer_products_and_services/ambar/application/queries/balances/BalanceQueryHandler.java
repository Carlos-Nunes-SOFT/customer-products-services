package com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.balances;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.BalanceDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.BalanceMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.BalanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BalanceQueryHandler {

    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;

    public BalanceQueryHandler(BalanceRepository balanceRepository, BalanceMapper balanceMapper) {
        this.balanceRepository = balanceRepository;
        this.balanceMapper = balanceMapper;
    }

    public List<BalanceDetailsDto> getBalances(){
        return this.balanceRepository.findAll().stream()
                .map(balanceMapper::toDto)
                .collect(Collectors.toList());
    }
}
