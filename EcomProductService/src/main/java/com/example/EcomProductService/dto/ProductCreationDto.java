package com.example.EcomProductService.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductCreationDto {
    private String title;
    private double price;
    private String description;
    private String imgURL;
    private double rating;
    private UUID categoryId;
}
