package com.example.EcomProductService.mapper;

import com.example.EcomProductService.dto.ProductCreationDto;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityDTOMapper {
    public static ProductResponseDTO converter(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setCategory(product.getCategory().getName());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setRating(product.getRating());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setImgURL(product.getImgURL());

        return responseDTO;
    }
    public static Product DtoToProductConvrter(ProductCreationDto productCreationDto){
        Product product = new Product();
        product.setTitle(productCreationDto.getTitle());
        product.setPrice(productCreationDto.getPrice());
        product.setRating(productCreationDto.getRating());
        product.setDescription(productCreationDto.getDescription());
        product.setImgURL(productCreationDto.getImgURL());
        return product;
    }
}
