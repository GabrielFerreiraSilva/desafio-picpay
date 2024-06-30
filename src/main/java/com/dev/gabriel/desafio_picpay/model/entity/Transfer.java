package com.dev.gabriel.desafio_picpay.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
public class Transfer {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  @ManyToOne
  @JoinColumn(name = "sender_id")
  private Wallet sender;

  @Column(nullable = false)
  @ManyToOne
  @JoinColumn(name = "receiver_id")
  private Wallet receiver;

  @Column(nullable = false)
  private BigDecimal value;
}
