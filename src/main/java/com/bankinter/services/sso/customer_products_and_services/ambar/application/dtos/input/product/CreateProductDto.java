package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.input.product;

public class CreateProductDto {

    private String type;

    private String value;

    public CreateProductDto(String type, String value) {
        this.type = type;
        this.value = value;
    }
}
