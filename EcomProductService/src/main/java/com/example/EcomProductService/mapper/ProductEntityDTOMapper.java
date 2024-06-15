package com.example.EcomProductService.mapper;

import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityDTOMapper {
    public static ProductResponseDTO converter(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductId(product.getProductId());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setRating(product.getRating());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setImgURL(product.getImgURL());

        return responseDTO;
    }
}
