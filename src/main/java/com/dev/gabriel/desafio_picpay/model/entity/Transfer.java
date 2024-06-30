package com.dev.gabriel.desafio_picpay.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Transfer {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "sender_id")
  private Wallet sender;

  @ManyToOne
  @JoinColumn(name = "receiver_id")
  private Wallet receiver;

  @Column(nullable = false)
  private BigDecimal value;
}
