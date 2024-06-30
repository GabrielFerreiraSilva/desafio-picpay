package com.dev.gabriel.desafio_picpay.service;

import com.dev.gabriel.desafio_picpay.client.AuthorizationClient;
import com.dev.gabriel.desafio_picpay.dto.AuthorizationClientResponse;
import com.dev.gabriel.desafio_picpay.exception.PicPayException;
import com.dev.gabriel.desafio_picpay.model.entity.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
  private final AuthorizationClient authorizationClient;

  public boolean isAuthorized(Transfer transfer) {
    ResponseEntity<AuthorizationClientResponse> response =
        this.authorizationClient.isAuthorized(transfer);

    if (response.getStatusCode().isError()) {
      throw new PicPayException();
    }

    return Objects.requireNonNull(response.getBody()).authorized();
  }
}
