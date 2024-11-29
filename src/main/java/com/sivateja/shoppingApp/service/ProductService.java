package com.sivateja.shoppingApp.service;

import com.sivateja.shoppingApp.entity.Product;
import com.sivateja.shoppingApp.model.ProductDTO;
import com.sivateja.shoppingApp.model.request.ProductRequest;
import com.sivateja.shoppingApp.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> productEntities = productRepository.findAll();
        List<ProductDTO> products = new ArrayList<>();
        productEntities.forEach(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            products.add(productDTO);
        });
        return products;
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product == null) {
            log.info("Product with id {} not found", id);
            return null;
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    public ProductDTO saveProduct(ProductDTO productRequest) {
        try {
            Product product = new Product();
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setPrice(productRequest.getPrice());
            Product savedProduct = productRepository.save(product);
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(savedProduct.getId());
            productDTO.setName(savedProduct.getName());
            productDTO.setDescription(savedProduct.getDescription());
            productDTO.setPrice(savedProduct.getPrice());
            return productDTO;
        } catch (Exception e) {
            log.error("Error while saving product", e);
            throw new RuntimeException(e);
        }

    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
