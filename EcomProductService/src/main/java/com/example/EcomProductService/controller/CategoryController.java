package com.example.EcomProductService.controller;


import com.example.EcomProductService.dto.CategoryCreationDTO;
import com.example.EcomProductService.dto.CategoryResponseDTO;
import com.example.EcomProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id")UUID id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PostMapping()
    public ResponseEntity<CategoryResponseDTO>createCategory(@RequestBody CategoryCreationDTO categoryCreationDTO){
        return ResponseEntity.ok(categoryService.createCategory(categoryCreationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO>updateCategory(@RequestBody CategoryCreationDTO categoryCreationDTO,@PathVariable("id")UUID uuid ){
        return  ResponseEntity.ok(categoryService.updateCategory(categoryCreationDTO, uuid));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategtoryById(@PathVariable("id")UUID id){
        return ResponseEntity.ok(categoryService.deletaCategoryById(id));
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<Double>getCategoryTotal(@PathVariable("id")UUID uuid){
        return ResponseEntity.ok(categoryService.getCategoryTotalPrice(uuid));

    }

}
