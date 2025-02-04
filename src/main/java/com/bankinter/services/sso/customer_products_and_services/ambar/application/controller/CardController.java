package com.bankinter.services.sso.customer_products_and_services.ambar.application.controller;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.card.CardCommandHandler;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.card.CreateCardCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.CardDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.card.CardQueryHandler;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.card.GetCardByIdQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.Servlet;
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
@Tag(name = "cards", description = "the cards API")
@RequestMapping("/api/v1/card")
public class CardController {

    private final CardCommandHandler cardCommandHandler;
    private final CardQueryHandler cardQueryHandler;

    public CardController(CardCommandHandler cardCommandHandler, CardQueryHandler cardQueryHandler) {
        this.cardCommandHandler = cardCommandHandler;
        this.cardQueryHandler = cardQueryHandler;
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

    @GetMapping("/cards")
    public ResponseEntity<List<CardDetailsDto>> getCards(){
        List<CardDetailsDto> cards = this.cardQueryHandler.getCards();

        return ResponseEntity.ok(cards);
    }

    @GetMapping
    public ResponseEntity<CardDetailsDto> getCardById(@RequestParam(name = "id") Long cardId){
        GetCardByIdQuery request = new GetCardByIdQuery(cardId);
        CardDetailsDto card = this.cardQueryHandler.getById(request);

        return ResponseEntity.ok(card);
    }
}
