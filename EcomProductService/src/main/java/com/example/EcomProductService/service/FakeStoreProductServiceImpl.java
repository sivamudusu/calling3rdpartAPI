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

@Service("fakestoreProductServiceImpl")
//@Primary
//you also can use @Qualifier
public class FakeStoreProductServiceImpl {

    @Autowired
    private FakeStoreClient fakeStoreClient;


    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        return fakeStoreProducts;
    }


    public FakeStoreProductResponseDTO getproduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO responseDTO = fakeStoreClient.getProductById(productId).getBody();
        if(responseDTO == null){
            throw new NotFoundException("product not found with id" + productId);
        }
        return responseDTO;
    }


    public Product createProduct(Product product) {
        return null;
    }


    public Product updateProduct(Product product, int productId) {
        return null;
    }


    public boolean deleteProduct(int productId) {
        return false;
    }
}
