package com.example.EcomProductService.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imgURL;
    private double rating;
}
