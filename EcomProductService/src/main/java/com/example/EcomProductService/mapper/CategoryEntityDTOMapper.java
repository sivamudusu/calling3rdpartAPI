package com.example.EcomProductService.mapper;

import com.example.EcomProductService.dto.CategoryCreationDTO;
import com.example.EcomProductService.dto.CategoryResponseDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.Category;
import com.example.EcomProductService.entity.Product;

import java.util.List;

public class CategoryEntityDTOMapper {

    public static CategoryResponseDTO categoryEntityToDTOConverter(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryId(category.getId());
        categoryResponseDTO.setCategoryName(category.getName());
        List<Product> products = category.getProducts();
        if(!(category.getProducts()==null || category.getProducts().isEmpty())){
            for (Product product : products){
                ProductResponseDTO productResponseDTO = ProductEntityDTOMapper.converter(product);
                categoryResponseDTO.getProducts().add(productResponseDTO);
            }
        }

        return  categoryResponseDTO;

    }
    public static Category categoryDTOToEntityMapper(CategoryCreationDTO categoryCreationDTO){
        Category category = new Category();
        category.setName(categoryCreationDTO.getCategoryName());
        return  category;
    }

}
