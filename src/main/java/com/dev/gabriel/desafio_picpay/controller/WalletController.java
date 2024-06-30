package com.dev.gabriel.desafio_picpay.controller;

import com.dev.gabriel.desafio_picpay.dto.CreateWalletRequest;
import com.dev.gabriel.desafio_picpay.dto.WalletResponse;
import com.dev.gabriel.desafio_picpay.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {
  private final WalletService walletService;

  @PostMapping
  public ResponseEntity<WalletResponse> createWallet(
      @RequestBody @Valid CreateWalletRequest request) {

    WalletResponse response = this.walletService.createWallet(request);

    return ResponseEntity.ok(response);
  }
}
