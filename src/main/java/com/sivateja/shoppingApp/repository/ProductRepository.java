package com.sivateja.shoppingApp.repository;

import com.sivateja.shoppingApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
