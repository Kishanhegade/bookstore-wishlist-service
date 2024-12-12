package com.bridgelabz.wishlistservice.exceptionhandler;

import com.bridgelabz.wishlistservice.exception.WishlistNotFoundByIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WishlistNotFoundByIdException.class)
    public ResponseEntity<String> handleWishlistNotFoundById(WishlistNotFoundByIdException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
