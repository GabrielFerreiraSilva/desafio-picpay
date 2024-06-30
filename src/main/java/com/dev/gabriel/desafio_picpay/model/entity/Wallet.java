package com.dev.gabriel.desafio_picpay.model.entity;

import com.dev.gabriel.desafio_picpay.model.enums.WalletType;

import java.math.BigDecimal;

public class Wallet {
  private Long id;
  private String name;
  private String cpfCnpj;
  private String email;
  private String password;
  private BigDecimal balance = BigDecimal.ZERO;
  private WalletType walletType;
}
