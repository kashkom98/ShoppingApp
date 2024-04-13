package com.shoppingapp.discoveryserver.productservice.repository;

import com.shoppingapp.discoveryserver.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
