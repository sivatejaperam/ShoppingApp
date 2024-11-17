package com.sivateja.shoppingApp.service;

import com.sivateja.shoppingApp.entity.Product;
import com.sivateja.shoppingApp.model.ProductDTO;
import com.sivateja.shoppingApp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> productEntities = productRepository.findAll();
        List<ProductDTO> products = new ArrayList<>();
        productEntities.stream().forEach(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            products.add(productDTO);
        });
        return products;
    }
}
