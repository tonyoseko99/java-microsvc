package com.developer.tonny.inventoryservice.exception;

import java.util.Map;

import com.developer.tonny.inventoryservice.model.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(NotEnoughQuantityException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public GenericResponse<Map<String, Integer>> handleProductNotFound(NotEnoughQuantityException ex) {
        GenericResponse<Map<String, Integer>> resp = GenericResponse.<Map<String, Integer>>builder()
                .success(false)
                .msg(ex.getMessage())
                .data(ex.getUnavailableItems())
                .build();
        return resp;
    }

}
