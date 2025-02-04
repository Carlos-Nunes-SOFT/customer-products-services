package com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.CardDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Card;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMapper {

    public CardDetailsDto toDto(Card card){
        if(card == null)
            return null;
        return new CardDetailsDto(card.getId(), card.getCardNumber(), card.getCardType(),
        card.getNameInCard(), card.getProductId(), card.getSubProductId(), card.getPropertyStatus());
    }

    public List<CardDetailsDto> toDtoList(List<Card> cards){
        return cards.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
