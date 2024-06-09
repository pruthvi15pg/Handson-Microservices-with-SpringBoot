package com.ms.userpg.Exception;


import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ms.userpg.Exception.ErrorResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers  {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ErrorResponse> handleException(UserNotFoundException ex){
        ErrorResponse er=ErrorResponse.builder()
                .Message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<Map<String,String>> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> errorMap=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
           String fieldName= ((FieldError)error).getField();
           String message=error.getDefaultMessage();
            errorMap.put(fieldName,message);
        });
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }


}
