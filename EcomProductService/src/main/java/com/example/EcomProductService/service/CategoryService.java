package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.CategoryCreationDTO;
import com.example.EcomProductService.dto.CategoryResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryResponseDTO>getAllCategories();
    CategoryResponseDTO getCategoryById(UUID id);
    CategoryResponseDTO createCategory(CategoryCreationDTO categoryCreationDTO);
    CategoryResponseDTO updateCategory(CategoryCreationDTO categoryCreationDTO, UUID uuid);
    Boolean deletaCategoryById(UUID uuid);
    Double getCategoryTotalPrice(UUID uuid);


}
