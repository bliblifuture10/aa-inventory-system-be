package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String>{
    Product findByIdEquals(String prod_id);
    Product findByName(String name);

    List<Product> findAllByNameContaining(String name);

    boolean existsById(String prod_id);
    boolean existsByNameContaining(String name);

    boolean deleteByIdEquals(String prod_id);
}
