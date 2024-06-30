package com.dev.gabriel.desafio_picpay.service;

import com.dev.gabriel.desafio_picpay.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {
  private final WalletRepository walletRepository;
}
