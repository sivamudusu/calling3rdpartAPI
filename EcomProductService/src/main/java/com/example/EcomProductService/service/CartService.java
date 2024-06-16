package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.FakeStoreCartResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<FakeStoreCartResponseDTO> getAllCarts();
    FakeStoreCartResponseDTO getCartById(int cartId);
    List<FakeStoreCartResponseDTO>limitCarts(int limit);
    List<FakeStoreCartResponseDTO>sortCart(String order);


}
