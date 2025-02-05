package com.bankinter.services.sso.customer_products_and_services.ambar.application.controller;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.balance.BalanceCommandHandler;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.balance.CreateBalanceCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.BalanceDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.balances.BalanceQueryHandler;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Balance;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Validated
@Tag(name = "balances", description = "This API is responsible for managing balances.")
@RequestMapping("/api/v1/balance")
public class BalanceController {

    private final BalanceCommandHandler balanceCommandHandler;
    private final BalanceQueryHandler balanceQueryHandler;

    public BalanceController(BalanceCommandHandler balanceCommandHandler, BalanceQueryHandler balanceQueryHandler) {
        this.balanceCommandHandler = balanceCommandHandler;
        this.balanceQueryHandler = balanceQueryHandler;
    }

    @PostMapping
    public ResponseEntity<BalanceDetailsDto> createBalance(@Valid @RequestBody CreateBalanceCommand request){
        BalanceDetailsDto balance = this.balanceCommandHandler.createBalance(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(balance.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/balances")
    public ResponseEntity<List<BalanceDetailsDto>> getBalances(){
        List<BalanceDetailsDto> balances = this.balanceQueryHandler.getBalances();

        return ResponseEntity.ok(balances);
    }

}
