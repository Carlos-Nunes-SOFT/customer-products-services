package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output;

public class ProductDetailsDto {
    private String id;

    private String type;

    private String value;

    public ProductDetailsDto(String id, String type, String value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }
}
