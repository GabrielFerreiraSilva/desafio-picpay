package com.dev.gabriel.desafio_picpay.controller;

import com.dev.gabriel.desafio_picpay.dto.CreateTransferRequest;
import com.dev.gabriel.desafio_picpay.dto.TransferResponse;
import com.dev.gabriel.desafio_picpay.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {
  private final TransferService transferService;

  @PostMapping
  public ResponseEntity<TransferResponse> transfer(
      @RequestBody @Valid CreateTransferRequest request) {
    TransferResponse response = this.transferService.createTransfer(request);
    return ResponseEntity.ok(response);
  }
}
