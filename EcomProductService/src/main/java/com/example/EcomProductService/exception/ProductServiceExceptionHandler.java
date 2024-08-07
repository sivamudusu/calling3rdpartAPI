package com.example.EcomProductService.exception;

import com.example.EcomProductService.controller.ProductController;
import com.example.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductServiceExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(ProductNotFoundException pe){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                pe.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException ce){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(ce.getMessage() , 404);
        return new ResponseEntity(exceptionResponseDTO , HttpStatus.NOT_FOUND);
    }
}
