package com.aa.aainventorysystembe.services;

import com.aa.aainventorysystembe.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(String prod_id);
    List<Product> getAllProduct();
    Product createProduct(Product product);
    Product updateProduct(String prod_id, Product product);

    boolean deleteProduct(String prod_id);
}
