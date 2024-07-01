package com.dev.gabriel.desafio_picpay.service;

import com.dev.gabriel.desafio_picpay.dto.CreateTransferRequest;
import com.dev.gabriel.desafio_picpay.dto.TransferResponse;
import com.dev.gabriel.desafio_picpay.exception.InsufficientBalanceException;
import com.dev.gabriel.desafio_picpay.exception.TransferNotAllowedException;
import com.dev.gabriel.desafio_picpay.exception.WalletNotFoundException;
import com.dev.gabriel.desafio_picpay.model.entity.Transfer;
import com.dev.gabriel.desafio_picpay.model.entity.Wallet;
import com.dev.gabriel.desafio_picpay.model.enums.WalletType;
import com.dev.gabriel.desafio_picpay.repository.TransferRepository;
import com.dev.gabriel.desafio_picpay.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransferService {
  private final TransferRepository transferRepository;
  private final WalletService walletService;
  private final WalletRepository walletRepository;
  private final AuthorizationService authorizationService;
  private final NotificationService notificationService;

  @Transactional
  public TransferResponse createTransfer(CreateTransferRequest request) {
    Wallet sender =
        this.walletRepository.findById(request.payer()).orElseThrow(WalletNotFoundException::new);

    Wallet receiver =
        this.walletRepository.findById(request.payee()).orElseThrow(WalletNotFoundException::new);

    validateTransfer(request, sender);

    this.walletService.debit(sender.getId(), request.value());
    this.walletService.credit(receiver.getId(), request.value());

    Transfer transfer = new Transfer(null, sender, receiver, request.value());
    Transfer savedTransfer = this.transferRepository.save(transfer);

    TransferResponse response = new TransferResponse(savedTransfer);

    CompletableFuture.runAsync(() -> this.notificationService.sendNotification(response));
    return response;
  }

  private void validateTransfer(CreateTransferRequest request, Wallet sender) {
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
