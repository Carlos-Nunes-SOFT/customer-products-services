package com.bankinter.services.sso.customer_products_and_services.ambar.domain.builder.product;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Product;

public class ProductBuilderImpl implements ProductBuilder{

    private Product product;

    @Override
    public Product build() {
        if(product==null)
            throw new IllegalArgumentException("The balance object is not initialized.");
        return product;
    }

    @Override
    public ProductBuilder newProduct(String type, String value) {
        product = new Product(type, value);
        return this;
    }
}
