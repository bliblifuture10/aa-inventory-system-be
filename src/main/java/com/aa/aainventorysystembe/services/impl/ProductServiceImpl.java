package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.Product;
import com.aa.aainventorysystembe.repositories.ProductRepository;
import com.aa.aainventorysystembe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(String prod_id) {
        if(!productRepository.existsById(prod_id))
        {
            throw new ResourceNotFoundException("Product With Id "+prod_id+" not found");
        }
        return productRepository.findByIdEquals(prod_id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(@PathVariable String prod_id,@Valid @RequestBody Product product) {
        if(!productRepository.existsById(prod_id)){
            throw new ResourceNotFoundException("Product with Id "+prod_id+" not found");
        }
        product.setId(prod_id);
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(@PathVariable String prod_id) {
        if(!productRepository.existsById(prod_id)){
            throw new ResourceNotFoundException("Product with Id "+prod_id+" not found");
        }
        return productRepository.deleteByIdEquals(prod_id);
    }
}
