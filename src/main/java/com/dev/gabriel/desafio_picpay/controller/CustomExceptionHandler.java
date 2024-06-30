package com.dev.gabriel.desafio_picpay.controller;

import com.dev.gabriel.desafio_picpay.exception.PicPayException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(PicPayException.class)
  public ProblemDetail handlePicPayException(PicPayException e) {
    return e.generateProblemDetail();
  }
}
