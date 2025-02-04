package com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

    @Id
    private String id;

    private String type;

    private String value;

    protected Product(){}

    public Product(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
