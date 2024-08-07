package com.example.EcomProductService.dto;

import com.example.EcomProductService.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private int productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imgURL;
    private double rating;

}
