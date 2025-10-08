package com.senai.conta_bancaria_turma2.interface_ui.exception;

import com.senai.conta_bancaria_turma2.domain.exceptions.ValoresNegativoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValoresNegativoException.class)
    public ResponseEntity<String> handleValoresNegativo(ValoresNegativoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
