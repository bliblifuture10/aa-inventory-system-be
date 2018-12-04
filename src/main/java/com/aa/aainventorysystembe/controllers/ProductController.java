package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.entity.Product;
import com.aa.aainventorysystembe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public  List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("id/{prodId}")
    public Optional<Product> getProduct(@PathVariable String prodId)
    {
        return productService.getProductById(prodId);
    }

    @GetMapping("name/{name}")
    public List<Product> getAllProductByName(@PathVariable String name)
    {
        return productService.getAllProductByName(name);
    }

    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product)
    {
        return productService.createProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@PathVariable String prodId)
    {
        productService.deleteProduct(prodId);
    }


}
