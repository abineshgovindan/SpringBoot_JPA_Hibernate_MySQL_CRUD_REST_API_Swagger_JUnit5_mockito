package com.springdev.SpringbootTutorial.error;

import com.springdev.SpringbootTutorial.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundExpection.class)
    public ResponseEntity<ErrorMessage> DepartmentNotFoundExpection(DepartmentNotFoundExpection expection, WebRequest request){
        ErrorMessage message= new ErrorMessage(HttpStatus.NOT_FOUND, expection.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

    }
}
