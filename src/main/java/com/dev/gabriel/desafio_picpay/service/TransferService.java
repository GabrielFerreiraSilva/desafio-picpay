package com.dev.gabriel.desafio_picpay.service;

import com.dev.gabriel.desafio_picpay.dto.CreateTransferRequest;
import com.dev.gabriel.desafio_picpay.exception.InsufficientBalanceException;
import com.dev.gabriel.desafio_picpay.exception.TransferNotAllowedException;
import com.dev.gabriel.desafio_picpay.model.entity.Wallet;
import com.dev.gabriel.desafio_picpay.model.enums.WalletType;
import com.dev.gabriel.desafio_picpay.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {
  private final TransferRepository transferRepository;
  private final WalletService walletService;
  private final AuthorizationService authorizationService;

  public void validateTransfer(CreateTransferRequest request, Wallet sender) {
    if (sender.getWalletType() != WalletType.COMMON_USER) {
      throw new TransferNotAllowedException(
          "Seu tipo de carteira não permite a realização de transferências");
    }

    if (sender.getBalance().doubleValue() < request.value().doubleValue()) {
      throw new InsufficientBalanceException("O saldo é insuficiente");
    }

    if (!this.authorizationService.isAuthorized(request)) {
      throw new TransferNotAllowedException("A transferência não foi autorizada");
    }
  }
}
