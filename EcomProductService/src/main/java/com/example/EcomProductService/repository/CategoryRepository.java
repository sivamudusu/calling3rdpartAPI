package com.example.EcomProductService.repository;

import com.example.EcomProductService.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
