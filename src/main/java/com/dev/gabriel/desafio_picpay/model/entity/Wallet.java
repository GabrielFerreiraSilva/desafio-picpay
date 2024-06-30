package com.dev.gabriel.desafio_picpay.model.entity;

import com.dev.gabriel.desafio_picpay.dto.CreateWalletRequest;
import com.dev.gabriel.desafio_picpay.model.enums.WalletType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_wallet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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

  public Wallet(CreateWalletRequest request) {
    this.name = request.name();
    this.cpfCnpj = request.cpfCnpj();
    this.email = request.email();
    this.password = request.password();
    this.walletType = request.walletType();
  }
}
