package com.sivateja.shoppingApp.model.request;

import lombok.Data;

@Data
public class ProductRequest {

    private String name;
    private String description;
    private double price;
}
