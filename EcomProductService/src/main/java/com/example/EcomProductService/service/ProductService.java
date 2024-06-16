package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.example.EcomProductService.entity.Product;
import com.example.EcomProductService.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<FakeStoreProductResponseDTO>getAllProducts();
    FakeStoreProductResponseDTO getproduct(int productId) throws ProductNotFoundException;
    Product createProduct(int productId);
    Product updateProduct(Product product, int productId);
    boolean deleteProduct(int productId);

}
