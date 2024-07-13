package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.CategoryCreationDTO;
import com.example.EcomProductService.dto.CategoryResponseDTO;
import com.example.EcomProductService.entity.Category;
import com.example.EcomProductService.entity.Product;
import com.example.EcomProductService.exception.CategoryNotFoundException;
import com.example.EcomProductService.mapper.CategoryEntityDTOMapper;
import com.example.EcomProductService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO>categoryResponseDTOS = new ArrayList<>();
        for (Category category : categories){
            CategoryResponseDTO categoryResponseDTO = CategoryEntityDTOMapper.categoryEntityToDTOConverter(category);
            categoryResponseDTOS.add(categoryResponseDTO);
        }
        return categoryResponseDTOS;
    }

    @Override
    public CategoryResponseDTO getCategoryById(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()-> new CategoryNotFoundException("category naot found with given id: "+id)
        );
        return (CategoryEntityDTOMapper.categoryEntityToDTOConverter(category));

    }

    @Override
    public CategoryResponseDTO createCategory(CategoryCreationDTO categoryCreationDTO) {
        Category category = CategoryEntityDTOMapper.categoryDTOToEntityMapper(categoryCreationDTO);

        category = categoryRepository.save(category);
        return (CategoryEntityDTOMapper.categoryEntityToDTOConverter(category));

    }

    @Override
    public CategoryResponseDTO updateCategory(CategoryCreationDTO categoryCreationDTO, UUID uuid) {
        return null;
    }

    @Override
    public Boolean deletaCategoryById(UUID uuid) {
        return null;
    }

    public Double getCategoryTotalPrice(UUID uuid){
       Category category = categoryRepository.findById(uuid).orElseThrow(
               ()-> new CategoryNotFoundException("category not found for the given id :"+uuid)
       );
       if(category.getProducts().isEmpty()){
           return  0.0;
       }else {
           double sum = 0;
           for (Product p : category.getProducts()){
               sum+=p.getPrice();
           }
           return sum;
       }
    }
}
