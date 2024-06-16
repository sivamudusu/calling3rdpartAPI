package com.example.EcomProductService.service;

import com.example.EcomProductService.Client.FakeStoreClient;
import com.example.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.example.EcomProductService.entity.Product;
import com.example.EcomProductService.exception.NotFoundException;
import com.example.EcomProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class FakeStoreProductServiceImpl implements ProductService{

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        return fakeStoreProducts;
    }

    @Override
    public FakeStoreProductResponseDTO getproduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO responseDTO = fakeStoreClient.getProductById(productId).getBody();
        if(responseDTO == null){
            throw new NotFoundException("product not found with id" + productId);
        }
        return responseDTO;
    }

    @Override
    public Product createProduct(int productId) {
        return null;
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
