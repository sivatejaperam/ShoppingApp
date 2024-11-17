package com.sivateja.shoppingApp.model;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
}
