package com.example.EcomProductService.exception;

import com.example.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartServiceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundExceptionHandler(NotFoundException ne){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(ne.getMessage(), 404);
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
