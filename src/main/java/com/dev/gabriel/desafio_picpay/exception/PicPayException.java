package com.dev.gabriel.desafio_picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicPayException extends RuntimeException {

  public ProblemDetail generateProblemDetail() {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    problemDetail.setTitle("PicPay API internal server error");

    return problemDetail;
  }
}
