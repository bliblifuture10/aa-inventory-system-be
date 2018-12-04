package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends MongoRepository<Product,String> {

    Optional<Product> findById(String prodId);
    Product findByName(String name);

    List<Product> findAllByNameContaining(String name);

    boolean existsById(String prodId);
    boolean existsByNameContaining(String name);

    void deleteByIdEquals(String prodId);
}
