package com.dev.gabriel.desafio_picpay.client;

import com.dev.gabriel.desafio_picpay.dto.AuthorizationClientResponse;
import com.dev.gabriel.desafio_picpay.dto.CreateTransferRequest;
import com.dev.gabriel.desafio_picpay.model.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authorization_client", url = "${client.authorization-service.url}")
public interface AuthorizationClient {

  @GetMapping
  ResponseEntity<AuthorizationClientResponse> isAuthorized(
      @RequestBody CreateTransferRequest transfer);
}
