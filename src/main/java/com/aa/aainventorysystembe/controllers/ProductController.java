package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Product;
import com.aa.aainventorysystembe.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/api/product")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("/api/product/{prod_id}")
    public Product getProduct(@PathVariable String prod_id){
        return productService.getProductById(prod_id);
    }
    @PostMapping("/api/product")
    public Product addProduct(@Valid @RequestBody Product product){
        return productService.createProduct(product);
    }
    @PutMapping("/api/product/{prod_id}")
    public Product updateProduct(@PathVariable String prod_id, @Valid @RequestBody Product product){
        return productService.updateProduct(prod_id,product);
    }
    @DeleteMapping("api/product/{prod_id}")
    public boolean deleteProduct(@PathVariable String prod_id){
        return productService.deleteProduct(prod_id);
    }


}
