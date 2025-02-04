package com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Balance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends MongoRepository<Balance, String> {
}
