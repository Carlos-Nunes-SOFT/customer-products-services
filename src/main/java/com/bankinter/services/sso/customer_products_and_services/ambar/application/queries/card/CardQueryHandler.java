package com.bankinter.services.sso.customer_products_and_services.ambar.application.queries.card;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.CardDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.exceptions.NotFoundException;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.CardMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardQueryHandler {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardQueryHandler(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    public CardDetailsDto getById(GetCardByIdQuery request){
        return this.cardRepository.findById(request.id)
                .map(cardMapper::toDto)
                .orElseThrow(() -> new NotFoundException("No such card with id: " + request.id));
    }

    public List<CardDetailsDto> getCards(){
        return this.cardRepository.findAll().stream()
                .map(cardMapper::toDto)
                .collect(Collectors.toList());
    }
}
