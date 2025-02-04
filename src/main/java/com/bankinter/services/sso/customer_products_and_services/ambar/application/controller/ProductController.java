package com.bankinter.services.sso.customer_products_and_services.ambar.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Tag(name = "products", description = "the products API")
@RequestMapping("/api/v1/products")
public class ProductController {
}
