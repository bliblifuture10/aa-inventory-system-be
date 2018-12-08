package com.aa.aainventorysystembe.services;

import com.aa.aainventorysystembe.models.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(String prodId);
    List<Product> getAllProduct();
    List<Product> getAllProductByName(String name);

    Product createProduct(Product product);
    Product updateProduct(Product product);

    void deleteProduct(String prodId);
}
