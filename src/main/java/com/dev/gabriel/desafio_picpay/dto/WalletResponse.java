package com.dev.gabriel.desafio_picpay.dto;

import com.dev.gabriel.desafio_picpay.model.entity.Wallet;
import com.dev.gabriel.desafio_picpay.model.enums.WalletType;

import java.math.BigDecimal;

public record WalletResponse(
    Long id, String name, String cpfCnpj, String email, BigDecimal balance, WalletType walletType) {

  public WalletResponse(Wallet wallet) {
    this(
        wallet.getId(),
        wallet.getName(),
        wallet.getCpfCnpj(),
        wallet.getEmail(),
        wallet.getBalance(),
        wallet.getWalletType());
  }
}
