package com.aa.aainventorysystembe.services;

import com.aa.aainventorysystembe.models.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product getProductById(String prodId);
    List<Product> getAllProduct();
    List<Product> getAllProductByName(String name);

    Product createProduct(Product product, String imageValue);
    Product updateProductById(String id, Product product, String imageValue);

    Boolean deleteProductById(String id);
}
