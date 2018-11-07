package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{
    Product findBy_id(String prod_id);
    Product findByName(String name);
}
