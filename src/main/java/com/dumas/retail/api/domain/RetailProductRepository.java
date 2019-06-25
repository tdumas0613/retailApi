package com.dumas.retail.api.domain;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RetailProductRepository extends MongoRepository<RetailProduct, String> {

    public Optional<RetailProduct> findByProductId(String productId);

}
