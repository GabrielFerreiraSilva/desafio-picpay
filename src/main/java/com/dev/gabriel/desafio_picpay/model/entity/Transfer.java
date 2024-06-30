package com.dev.gabriel.desafio_picpay.model.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Transfer {
  private UUID id;
  private Wallet sender;
  private Wallet receiver;
  private BigDecimal value;
}
