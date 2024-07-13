package com.example.EcomProductService.controller;

import com.example.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.example.EcomProductService.dto.ProductCreationDto;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.Product;
import com.example.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService; // field injedction

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID productId){
        ProductResponseDTO responseDTO = productService.getproduct(productId);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductCreationDto productCreationDto){
        ProductResponseDTO savedProduct = productService.createProduct(productCreationDto);
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id")UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
    @GetMapping("/name/{title}")
    public ResponseEntity<ProductResponseDTO> getProductByTitle(@PathVariable("title")String title){
        return ResponseEntity.ok(productService.getProductByTitle(title));

    }
    @GetMapping("/price/{min}/{max}")
    public ResponseEntity getBypriceBetween(@PathVariable("min")double min, @PathVariable("max")double max){
        return ResponseEntity.ok(productService.getByPriceBetween(min,max));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id")UUID id, @RequestBody ProductCreationDto productCreationDto){
        ProductResponseDTO updatedProduct = productService.updateProduct(productCreationDto,id);
        return ResponseEntity.ok(updatedProduct);
    }
}
