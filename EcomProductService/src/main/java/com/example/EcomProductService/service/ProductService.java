package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.example.EcomProductService.dto.ProductCreationDto;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.Product;
import com.example.EcomProductService.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productService")
public interface ProductService {
    List<ProductResponseDTO>getAllProducts();
    ProductResponseDTO getProductByTitle(String title);
    ProductResponseDTO getproduct(UUID productId) throws ProductNotFoundException;
    ProductResponseDTO createProduct(ProductCreationDto productCreationDto);
    ProductResponseDTO updateProduct(ProductCreationDto productCreationDto, UUID productId);
    boolean deleteProduct(UUID productId);
    List<Product>getByPriceBetween(double min,double max);

}
