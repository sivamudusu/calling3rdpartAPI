package com.example.EcomProductService.service;

import com.example.EcomProductService.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CategoryServiceImplTest {

    @Mock // @Mock for all dependencies
    private CategoryRepository categoryRepository;
    @InjectMocks // @InjectMocks for the actual class we are testing
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); // not required now days but this is only for the demo
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