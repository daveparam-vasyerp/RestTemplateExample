package com.vasy.resttemplate.exception;

import com.vasy.resttemplate.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto> handlerResponseNotFoundException(ResourceNotFoundException exception) {

        String message = exception.getMessage();
        ResponseDto response = ResponseDto.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<ResponseDto>(response,HttpStatus.NOT_FOUND);
    }
}
