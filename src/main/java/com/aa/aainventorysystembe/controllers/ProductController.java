package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Product;
import com.aa.aainventorysystembe.repositories.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.PublicKey;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/api/product")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    @GetMapping("/api/product/{prod_id}")
    public Product getProduct(@PathVariable String prod_id){
        return productRepository.findBy_id(prod_id);
    }

    @PostMapping("/api/product")
    public Product addProduct(@Valid @RequestBody Product product){

        product.set_id(product.get_id());
        return productRepository.save(product);
    }


}
