package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(FizzException.class)
public final ResponseEntity<Object> handleFizzException(FizzException fizzexception){
  GlobalError error=new GlobalError(fizzexception.getMessage(),fizzexception.getErrorReason());
return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);

}

@ExceptionHandler(BuzzException.class)
public final ResponseEntity<Object> handleBuzzException(BuzzException buzzexception){
GlobalError error=new GlobalError(buzzexception.getMessage(),buzzexception.getErrorReason());
return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(FizzBuzzException.class)
public final ResponseEntity<Object> handleFizzBuzzException(FizzBuzzException fizzbuzzexception){
  GlobalError error=new GlobalError(fizzbuzzexception.getMessage(),fizzbuzzexception.getErrorReason());
  return new ResponseEntity<>(error,HttpStatus.INSUFFICIENT_STORAGE);
}

}
