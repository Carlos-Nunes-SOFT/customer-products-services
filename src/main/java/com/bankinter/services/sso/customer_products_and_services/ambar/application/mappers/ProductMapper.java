package com.bankinter.services.sso.customer_products_and_services.ambar.application.mappers;

import com.bankinter.services.sso.customer_products_and_services.ambar.application.dtos.output.ProductDetailsDto;
import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDetailsDto toDto(Product product){
        if(product == null)
            return null;
        return new ProductDetailsDto(product.getId(), product.getType(), product.getValue());
    }
}
