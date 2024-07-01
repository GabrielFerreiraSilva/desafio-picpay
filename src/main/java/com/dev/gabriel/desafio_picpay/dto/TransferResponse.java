package com.dev.gabriel.desafio_picpay.dto;

import com.dev.gabriel.desafio_picpay.model.entity.Transfer;

import java.math.BigDecimal;
import java.util.UUID;

public record TransferResponse(UUID id, Long senderId, Long receiverId, BigDecimal value) {

  public TransferResponse(Transfer transfer) {
    this(
        transfer.getId(),
        transfer.getSender().getId(),
        transfer.getReceiver().getId(),
        transfer.getValue());
  }
}
