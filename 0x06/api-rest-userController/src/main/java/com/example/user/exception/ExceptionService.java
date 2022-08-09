package com.example.user.exception;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserErrorResponse;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionService {

    @ExceptionHandler(UserIdException.class)
    ResponseEntity<UserIdException> handleUserIdException(UserIdException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered ID "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNameException.class)
    ResponseEntity<UserNameException> handleUserNameException(UserNameException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered Username "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CPFException.class)
    ResponseEntity<CPFException> handleCPFException(CPFException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered CPF "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer, HttpStatus.NOT_FOUND);
    }

}
