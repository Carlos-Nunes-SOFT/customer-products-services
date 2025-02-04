package com.bankinter.services.sso.customer_products_and_services.ambar.domain.services;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.commands.products.CreateProductCommand;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.ProductDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.exceptions.NotFoundException;
import com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers.ProductMapper;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.product.ProductBuilder;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Product;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.AccountRepository;
import com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AccountRepository accountRepository;
    private final ProductBuilder productBuilder;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(AccountRepository accountRepository, ProductBuilder productBuilder,
                          ProductRepository productRepository, ProductMapper productMapper) {
        this.accountRepository = accountRepository;
        this.productBuilder = productBuilder;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Transactional
    public ProductDetailsDto createProduct(CreateProductCommand request){

        Account account = this.accountRepository.findById(request.accountId)
                .orElseThrow(() -> new NotFoundException("No such account with id: " + request.accountId));

        Product product = this.productBuilder
                .newProduct(request.type, request.value)
                .build();

        this.productRepository.save(product);

        account.setSubProductId(product.getId());
        this.accountRepository.save(account);

        return this.productMapper.toDto(product);
    }
}
