package com.suarez.apirest.infraestructure.handlers;


import com.suarez.apirest.domain.exceptions.user.UserAlreadyExistException;
import com.suarez.apirest.domain.exceptions.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final HashMap<String, Object> response = new HashMap<>();

    @ExceptionHandler({UserNotFoundException.class})
    ResponseEntity<HashMap<String,Object>> handleException(UserNotFoundException exception){
        response.put("error", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    ResponseEntity<HashMap<String,Object>> handleException(UserAlreadyExistException exception){
        response.put("error", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    ResponseEntity<HashMap<String,Object>> handleException(MethodArgumentNotValidException ex){
        final HashMap<String, Object> response = new HashMap<>();

        BindingResult result = ex.getBindingResult();

        ArrayList<String> errorMessage = new ArrayList<>();
        for(FieldError error : result.getFieldErrors()){
            errorMessage.add(error.getDefaultMessage());
        }

        response.put("error", errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
