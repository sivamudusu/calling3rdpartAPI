package com.example.EcomProductService.exception;

import com.example.EcomProductService.controller.CartController;
import com.example.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
//by mentioning basePackageClasses we are making sure that this controller advice is handling the exceptions that has generated in the controller class that has mentioned
public class CartServiceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundExceptionHandler(NotFoundException ne){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(ne.getMessage(), 404);
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
