package com.example.EcomProductService.repository;

import com.example.EcomProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByTitle(String ProductTitle);
    Product findFirstProductByTitle(String ProductTitle);
    List<Product>findByPriceBetween(double minPrice, double maxPrice);


}
