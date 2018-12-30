package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Response;
import com.aa.aainventorysystembe.models.entity.Product;
import com.aa.aainventorysystembe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
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
    public Response<Product> addProduct(
            @RequestParam MultipartFile file,
            @Valid @ModelAttribute Product product)
    {
        String imageValue = null;

        try{
            imageValue = saveUploadedFiles(file, "products");
        }catch(IOException e){}

        return toResponse(productService.createProduct(product, imageValue));
    }

    @PutMapping("/id/{id}")
    public Response<Product> updateProductById(
            @PathVariable String id,
            @RequestParam MultipartFile file,
            @Valid @ModelAttribute Product product)
    {
        String imageValue = null;

        try{
            imageValue = saveUploadedFiles(file, "products");
        }catch(IOException e){}

        return toResponse(productService.updateProductById(id, product, imageValue));
    }

    @DeleteMapping("/id/{id}")
    public Response<Boolean> deleteProductById(@PathVariable String id)
    {
        return toResponse(productService.deleteProductById(id));
    }

}
