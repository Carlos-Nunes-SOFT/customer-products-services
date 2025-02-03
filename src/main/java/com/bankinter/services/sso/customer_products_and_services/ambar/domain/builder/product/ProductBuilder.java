package com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.product;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Product;

public interface ProductBuilder {
    Product build();
    ProductBuilder newProduct(String type, String value);
}
