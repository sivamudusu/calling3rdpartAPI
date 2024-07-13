package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.example.EcomProductService.dto.ProductCreationDto;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.Category;
import com.example.EcomProductService.entity.Product;
import com.example.EcomProductService.exception.CategoryNotFoundException;
import com.example.EcomProductService.exception.NotFoundException;
import com.example.EcomProductService.exception.ProductNotFoundException;
import com.example.EcomProductService.mapper.ProductEntityDTOMapper;
import com.example.EcomProductService.repository.CategoryRepository;
import com.example.EcomProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product>products = productRepository.findAll();
        List<ProductResponseDTO>productResponseDTOS = new ArrayList<>();
        for (Product product : products){
            productResponseDTOS.add(ProductEntityDTOMapper.converter(product));
        }
        return  productResponseDTOS;


    }

    @Override
    public ProductResponseDTO getproduct(UUID productId) {
//        basic code to get the data
//        Product product = productRepository.findById(productId).get();
//        if(product==null){
//            throw new ProductNotFoundException("product not found with id :"+productId);
//        }
//        return  product;

//        optimised code using lamda functions
        Product product =  productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("product not found for id :"+productId)
        );

        return (ProductEntityDTOMapper.converter(product));
    }

    @Override
    public ProductResponseDTO getProductByTitle(String title){
        Product product = productRepository.findProductByTitle(title);
        if(product == null){
            throw new NotFoundException("product not found with given name :"+title);
        }
        return ProductEntityDTOMapper.converter(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductCreationDto productCreationDto) {
        Product product = ProductEntityDTOMapper.DtoToProductConvrter(productCreationDto);
        Category savedCategory = categoryRepository.findById(productCreationDto.getCategoryId()).orElseThrow(
                ()-> new CategoryNotFoundException("category not found with the given id :"+productCreationDto.getCategoryId())
        );

        product.setCategory(savedCategory);
        product = productRepository.save(product);
        return ProductEntityDTOMapper.converter(product);
    }

    @Override
    public ProductResponseDTO updateProduct(ProductCreationDto productCreationDto, UUID productId) {
        Product updatedProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("product not found for the id :"+productId)
        );
        updatedProduct.setPrice(productCreationDto.getPrice());
        updatedProduct.setDescription(productCreationDto.getDescription());
        updatedProduct.setImgURL(productCreationDto.getImgURL());
        updatedProduct.setTitle(productCreationDto.getTitle());
        Product savedProduct = productRepository.save(updatedProduct);
        return ProductEntityDTOMapper.converter(savedProduct);
    }

    @Override
    public List<Product> getByPriceBetween(double min, double max){
        return productRepository.findByPriceBetween(min, max);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }
}
