package com.dev.gabriel.desafio_picpay.controller;

import com.dev.gabriel.desafio_picpay.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {
  private final WalletService walletService;
}
