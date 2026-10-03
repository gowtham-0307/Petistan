package com.gowravee.petistan.controlleradvice;

import com.gowravee.petistan.dto.ErrorDTO;
import com.gowravee.petistan.exception.OwnerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleNotFoundException(OwnerNotFoundException e) {
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), java.time.LocalDateTime.now());
        return ResponseEntity.status(errorDTO.status()).body(errorDTO);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleMethodNotAllowedException(HttpRequestMethodNotSupportedException exception) {
        ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), HttpStatus.METHOD_NOT_ALLOWED,
                HttpStatus.METHOD_NOT_ALLOWED.value(), LocalDateTime.now());
        return ResponseEntity.status(errorDTO.status()).body(errorDTO);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleGenericException(Exception exception) {
        ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        return ResponseEntity.status(errorDTO.status()).body(errorDTO);
    }
}
