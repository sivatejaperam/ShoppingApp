package com.sivateja.shoppingApp.controller;

import com.sivateja.shoppingApp.model.ProductDTO;
import com.sivateja.shoppingApp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController{

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts(){
       return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public void getProductById(Long id){

    }

    @PostMapping("/product")
    public void createProduct(ProductDTO productRequest){

    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(Long id){

    }
}
