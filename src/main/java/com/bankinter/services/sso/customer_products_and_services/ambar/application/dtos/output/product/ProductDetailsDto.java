package com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.product;

public class ProductDetailsDto {
    private Long id;

    private String type;

    private String value;

    public ProductDetailsDto(Long id, String type, String value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }
}
