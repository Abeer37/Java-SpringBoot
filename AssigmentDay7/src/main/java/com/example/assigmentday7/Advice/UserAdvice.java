package com.example.assigmentday7.Advice;

import com.example.assigmentday7.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdvice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException u){
        String message=u.getMessage();
        return ResponseEntity.status(400).body(message);
    }
}
