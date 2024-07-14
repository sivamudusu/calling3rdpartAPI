package com.example.EcomProductService.controller;

import com.example.EcomProductService.dto.CategoryCreationDTO;
import com.example.EcomProductService.dto.CategoryResponseDTO;
import com.example.EcomProductService.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class CategoryControllerTest {
    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateCategorySuccess(){
        CategoryCreationDTO categoryCreationDTO = new CategoryCreationDTO();
        categoryCreationDTO.setCategoryName("testCategory");

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryId(UUID.randomUUID());
        categoryResponseDTO.setCategoryName("testCategory");

        UUID categoryId = UUID.randomUUID();

        Mockito.when(categoryService.updateCategory(categoryCreationDTO,categoryId)).thenReturn(categoryResponseDTO);

        ResponseEntity<CategoryResponseDTO> categoryResponseDTOResponseEntity = categoryController.updateCategory(categoryCreationDTO, categoryId);

        Assertions.assertEquals(categoryResponseDTO , categoryResponseDTOResponseEntity.getBody());

    }
}
