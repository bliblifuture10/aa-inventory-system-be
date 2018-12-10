package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Response;
import com.aa.aainventorysystembe.models.entity.Product;
import com.aa.aainventorysystembe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController extends GlobalController{

    @Autowired
    private ProductService productService;

    @GetMapping
    public Response<List<Product>> getAllProduct(){
        return toResponse(productService.getAllProduct());
    }

    @GetMapping("/id/{id}")
    public Response<Product> getProductById(@PathVariable String id)
    {
        return toResponse(productService.getProductById(id));
    }

    @GetMapping("/name/{name}")
    public Response<Product> getAllProductByName(@PathVariable String name)
    {
        return toResponse(productService.getAllProductByName(name));
    }

    @PostMapping
    public Response<Product> addProduct(@Valid @RequestBody Product product)
    {
        return toResponse(productService.createProduct(product));
    }

    @PutMapping("/id/{id}")
    public Response<Product> updateProductById(@PathVariable String id, @Valid @RequestBody Product product){
        return toResponse(productService.updateProductById(id, product));
    }

    @DeleteMapping("/id/{id}")
    public Response<Boolean> deleteProductById(@PathVariable String id)
    {
        return toResponse(productService.deleteProductById(id));
    }

}
