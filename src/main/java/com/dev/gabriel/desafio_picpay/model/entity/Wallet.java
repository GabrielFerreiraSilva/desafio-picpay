package com.dev.gabriel.desafio_picpay.model.entity;

import com.dev.gabriel.desafio_picpay.model.enums.WalletType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_wallet")
public class Wallet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String cpfCnpj;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private BigDecimal balance = BigDecimal.ZERO;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private WalletType walletType;
}
