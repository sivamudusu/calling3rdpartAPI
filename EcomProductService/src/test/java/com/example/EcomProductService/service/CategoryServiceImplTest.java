package com.example.EcomProductService.service;

import com.example.EcomProductService.entity.Category;
import com.example.EcomProductService.entity.Product;
import com.example.EcomProductService.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {

    @Mock // @Mock for all dependencies
    private CategoryRepository categoryRepository;
    @InjectMocks // @InjectMocks for the actual class we are testing
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); // not required now days but this is only for the demo
    }

    @Test
    public void testGetTotalPriceForCategory(){
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.ofNullable(getCategoryMockData()));
        double totalCost = categoryService.getCategoryTotalPrice(categoryId);
        double expectedCost = 300.00;
        Assertions.assertEquals(totalCost,expectedCost);


    }

    public Category getCategoryMockData(){
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("testCategory");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("product1");
        product1.setPrice(100.00);
        product1.setCategory(category);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("product2");
        product2.setPrice(200.00);
        product2.setCategory(category);

        List<Product>products = new ArrayList<>();
        products.add(product2);
        products.add(product1);

        category.setProducts(products);
        return  category;
    }


}


// @Before -> is used for setting up the env
// --- runs ony once when we are executing the tests in the class
// @After -> is used only for destroying the env
// --- runs only after we are executing the tests in the class
// @BeforeEach -> is used for setting up all tests
// --- runs before every test case
// @AfterEach -> is used for destroying for all tests
// --- runs after every test case