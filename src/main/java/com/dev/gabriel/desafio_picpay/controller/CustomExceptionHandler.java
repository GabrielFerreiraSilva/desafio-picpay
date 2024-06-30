package com.dev.gabriel.desafio_picpay.controller;

import com.dev.gabriel.desafio_picpay.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(PicPayException.class)
  public ProblemDetail handlePicPayException(PicPayException e) {
    return e.generateProblemDetail();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleValidationException(MethodArgumentNotValidException e) {

    List<InvalidParam> fieldErrors =
        e.getFieldErrors().stream()
            .map(error -> new InvalidParam(error.getField(), error.getDefaultMessage()))
            .toList();

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Request parameters did not validate");
    problemDetail.setProperty("Parâmetros inválidos", fieldErrors);

    return problemDetail;
  }

  private record InvalidParam(String name, String reason) {}
}
