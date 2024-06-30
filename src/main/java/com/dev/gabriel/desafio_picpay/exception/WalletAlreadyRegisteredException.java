package com.dev.gabriel.desafio_picpay.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

@AllArgsConstructor
public class WalletAlreadyRegisteredException extends PicPayException {
  private final String description;

  @Override
  public ProblemDetail generateProblemDetail() {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
    problemDetail.setTitle("Wallet already registered");
    problemDetail.setDetail(description);

    return problemDetail;
  }
}
