package com.codigo.msventaspro.controller.advice;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Log4j2
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejandoExepciones(Exception ex){
        log.error("Error manejado desde ******Exception******* ");
        String error = "ERROR INTERNO DEL SERVIDOR: " + ex.getMessage();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> manejandoNullPointer(NullPointerException ex){
        //Aqui manejo exclusivamente lo qeu sucede cuando capturo una exepcion general.
        log.error("Error manejado desde ******manejandoNullPointer******* ");
        String error = "ERROR INTERNO DEL SERVIDOR: " + ex.getMessage();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> manejandoRuntime(RuntimeException ex){
        //Aqui manejo exclusivamente lo qeu sucede cuando capturo una exepcion general.
        log.error("Error manejado desde ******RuntimeException******* ");
        String error = "ERROR INTERNO DEL SERVIDOR: " + ex.getMessage();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> manejandoNoSuch(NoSuchElementException ex){
        //Aqui manejo exclusivamente lo qeu sucede cuando capturo una exepcion general.
        log.error("Error manejado desde ******NoSuchElementException******* ");
        String error = "ERROR INTERNO DEL SERVIDOR: " + ex.getMessage();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> manejandoIlegal(IllegalArgumentException ex){
        //Aqui manejo exclusivamente lo qeu sucede cuando capturo una exepcion general.
        log.error("Error manejado desde ******IllegalArgumentException******* ");
        String error = "ERROR INTERNO DEL SERVIDOR: " + ex.getMessage();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }



}
