package com.ventas.api.exception;


//Clase manejadora de todas la excepciones

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    // Aqui es necesario retornar la misma clase de objeto en este caso response entity el tipo
    //
    public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                "Ocurrio un error",
                e.getMessage()
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    };
}
