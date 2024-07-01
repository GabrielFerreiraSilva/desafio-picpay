package com.dev.gabriel.desafio_picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends PicPayException {
  @Override
  public ProblemDetail generateProblemDetail() {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
    problemDetail.setTitle("Wallet not found");

    return problemDetail;
  }
}
