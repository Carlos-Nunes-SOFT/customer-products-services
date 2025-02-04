package com.bankinter.services.sso.customer_products_and_services.ambar.infrastructure.repository;

import com.bankinter.services.sso.customer_products_and_services.ambar.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
}
