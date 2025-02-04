package com.bankinter.services.sso.customer_products_and_services.ambar.application.controller;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.card.CardCommandHandler;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.card.CreateCardCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.CardDetailsDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.Servlet;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Validated
@Tag(name = "cards", description = "the cards API")
@RequestMapping("/api/v1/card")
public class CardController {

    private final CardCommandHandler cardCommandHandler;

    public CardController(CardCommandHandler cardCommandHandler) {
        this.cardCommandHandler = cardCommandHandler;
    }

    @PostMapping
    public ResponseEntity<CardDetailsDto> createCard(@Valid @RequestBody CreateCardCommand request){
        CardDetailsDto card = this.cardCommandHandler.createCard(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand((card.getId()))
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
