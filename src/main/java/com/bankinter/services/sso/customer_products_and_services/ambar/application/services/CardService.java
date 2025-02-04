package com.bankinter.services.sso.customer_products_and_services.ambar.application.services;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.card.CreateCardCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.CardDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.exceptions.NotFoundException;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.CardMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.card.CardBuilder;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Card;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.AccountRepository;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.CardRepository;
import jakarta.persistence.Transient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final CardBuilder cardBuilder;
    private final CardMapper cardMapper;

    public CardService(CardRepository cardRepository, AccountRepository accountRepository, CardBuilder cardBuilder, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
        this.cardBuilder = cardBuilder;
        this.cardMapper = cardMapper;
    }

    @Transactional
    public CardDetailsDto createCard(CreateCardCommand request){

        Account account = this.accountRepository.findById(request.accountId)
                .orElseThrow(() -> new NotFoundException("No such account with id: " + request.accountId));

        Card card = this.cardBuilder
                .newCard(request.propertyStatus, request.subProductId, request.productId, request.nameInCard,
                        request.cardType, request.cardNumber)
                .build();

        this.cardRepository.save(card);

        account.addCard(card.getId());
        this.accountRepository.save(account);

        return this.cardMapper.toDto(card);
    }
}
