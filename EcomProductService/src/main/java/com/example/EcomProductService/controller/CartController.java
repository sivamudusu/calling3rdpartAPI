package com.example.EcomProductService.controller;

import com.example.EcomProductService.dto.FakeStoreCartResponseDTO;
import com.example.EcomProductService.service.CartService;
import com.example.EcomProductService.service.FakeStoreCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    @Qualifier("fakestoreCartService")
    private CartService cartService;


    @GetMapping("/carts")
    public ResponseEntity getAllCarts(){
        List<FakeStoreCartResponseDTO> carts = cartService.getAllCarts();
        return ResponseEntity.ok(carts);
    }
    @GetMapping("/carts/{id}")
    public ResponseEntity getCartById(@PathVariable("id") int cartId){
        FakeStoreCartResponseDTO cartResponseDTO = cartService.getCartById(cartId);
        return ResponseEntity.ok(cartResponseDTO);
    }

}
