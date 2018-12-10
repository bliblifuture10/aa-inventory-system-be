package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.ErrorCode;
import com.aa.aainventorysystembe.models.entity.Product;
import com.aa.aainventorysystembe.repositories.ProductRepository;
import com.aa.aainventorysystembe.repositories.ProductRepositoryCustomAPI;
import com.aa.aainventorysystembe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductRepositoryCustomAPI productRepositoryCustomAPI;

    @Override
    public Product getProductById(String prodId) {
        return productRepository.findById(prodId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorCode.NOT_FOUND.getCode(),
                        ErrorCode.NOT_FOUND.getMessage())
                );
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductByName(String name) {
        if(!productRepository.existsByNameContaining(name))
        {
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProductById(String id, Product productReq) {
        return productRepository.findById(id).map(product -> {
            product.setName(productReq.getName());
            product.setCategory(productReq.getCategory());
            product.setStock(productReq.getStock());
            product.setPrice(productReq.getPrice());

            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException(
                ErrorCode.NOT_FOUND.getCode(),
                ErrorCode.NOT_FOUND.getMessage()
        ));
    }

    @Override
    public Boolean deleteProductById(String id) {
        if(!productRepository.existsById(id))
        {
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        return productRepository.deleteByIdEquals(id);
    }
}
