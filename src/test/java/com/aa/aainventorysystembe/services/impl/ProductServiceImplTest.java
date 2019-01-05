package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.MockingObject.FakeObjectFactory;
import com.aa.aainventorysystembe.models.entity.Product;
import com.aa.aainventorysystembe.repositories.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("TearDown");
    }

    @Test
    public void getProductById() {
        Product product = FakeObjectFactory.getFakeProduct();
        when(productRepository.findById(product.getId())).thenReturn(java.util.Optional.ofNullable(product));

        Product returned = productService.getProductById(product.getId());

        verify(productRepository, times(1)).findById(product.getId());
        assertEquals(product,returned);
    }

    @Test
    public void getAllProduct() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(Product.builder().name("Prod-01").build()
                , Product.builder().name("Prod-2").build()));
        List<Product> products = productService.getAllProduct();

        assertEquals(products, productRepository.findAll());
    }

    @Test
    public void getAllProductByName() {
        Product product = FakeObjectFactory.getFakeProduct();
        when(productRepository.existsByNameContaining(product.getName())).thenReturn(true);

        List<Product> products = productService.getAllProductByName(product.getName());
        verify(productRepository, times(1)).existsByNameContaining(product.getName());
        assertEquals(products, productRepository.findAllByNameContaining(product.getName()));
    }

    @Test
    public void createProduct() {
        Product product =FakeObjectFactory.getFakeProduct();
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product rtrn = productService.createProduct(product, product.getImage());
        verify(productRepository, times(1)).save(any(Product.class));

        assertEquals(product, rtrn);
    }

    @Test
    public void updateProductById() {
        Product old = FakeObjectFactory.getFakeProduct();
        Product upd = FakeObjectFactory.getFakeProduct();
        upd.setName("Update-01");

        when(productRepository.findById(old.getId())).thenReturn(java.util.Optional.ofNullable(old));
        when(productRepository.save(any(Product.class))).thenReturn(upd);

        Product returned = productService.updateProductById(old.getId(), upd, upd.getImage());

        verify(productRepository, times(1)).findById(old.getId());
        verify(productRepository, times(1)).save(any(Product.class));

        assertEquals(upd, returned);
    }

    @Test
    public void deleteProductById() {
        Product product = FakeObjectFactory.getFakeProduct();

        when(productRepository.existsById(product.getId())).thenReturn(true);

        boolean status = productService.deleteProductById(product.getId());
        assertEquals(productRepository.deleteByIdEquals(product.getId()), status);
    }
}