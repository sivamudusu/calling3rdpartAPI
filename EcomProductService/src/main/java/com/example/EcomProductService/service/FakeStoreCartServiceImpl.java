package com.example.EcomProductService.service;

import com.example.EcomProductService.Client.FakeStoreClient;
import com.example.EcomProductService.dto.FakeStoreCartResponseDTO;
import com.example.EcomProductService.exception.CartNotFoundException;
import com.example.EcomProductService.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreCartServiceImpl implements CartService{
    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Override
    public List<FakeStoreCartResponseDTO> getAllCarts() {
        List<FakeStoreCartResponseDTO> carts = fakeStoreClient.getAllCarts();
        return carts;
    }

    @Override
    public FakeStoreCartResponseDTO getCartById(int cartId) {
        FakeStoreCartResponseDTO cartResponseDTO = fakeStoreClient.getcartById(cartId);
        if(cartResponseDTO == null){
            throw new NotFoundException("the cart you are requesting is not found: " + cartId);
        }
        return cartResponseDTO;
    }

    @Override
    public List<FakeStoreCartResponseDTO> limitCarts(int limit) {
        return null;
    }

    @Override
    public List<FakeStoreCartResponseDTO> sortCart(String order) {
        return null;
    }
}
