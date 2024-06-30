package com.dev.gabriel.desafio_picpay.service;

import com.dev.gabriel.desafio_picpay.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {
  private final TransferRepository transferRepository;
  private final WalletService walletService;
}
