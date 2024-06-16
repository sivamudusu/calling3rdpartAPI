package com.example.EcomProductService.Client;

import com.example.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}") // this annotation will fetch the value from application properties and inject here
    private String fakeStoreApiBaseURL;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreApiProductPath;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductsURl = fakeStoreApiBaseURL .concat(fakeStoreApiProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]>productResponseList = restTemplate.getForEntity(fakeStoreGetAllProductsURl, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }

    public ResponseEntity<FakeStoreProductResponseDTO> getProductById(int productId){
        String fakeStoreGetProductByidURL  = fakeStoreApiBaseURL.concat(fakeStoreApiProductPath).concat("/"+""+productId);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(fakeStoreGetProductByidURL, FakeStoreProductResponseDTO.class);
        return productResponse;
    }


}
