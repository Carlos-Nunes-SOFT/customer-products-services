package com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.card;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.CardDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.services.CardService;
import org.springframework.stereotype.Service;

@Service
public class CardCommandHandler {
    private final CardService cardService;

    public CardCommandHandler(CardService cardService) {
        this.cardService = cardService;
    }

    public CardDetailsDto createCard(CreateCardCommand request){
        return this.cardService.createCard(request);
    }
}
