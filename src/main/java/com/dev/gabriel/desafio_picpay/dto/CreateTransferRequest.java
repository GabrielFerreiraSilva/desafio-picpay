package com.dev.gabriel.desafio_picpay.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateTransferRequest(
    @DecimalMin(value = "0.1", message = "A transferência deve ter o valor mínimo de 10 centavos")
        @NotNull(message = "O campo valor não pode ser nulo")
        BigDecimal value,
    @NotNull(message = "O campo pagador não pode ser nulo") Long payer,
    @NotNull(message = "O campo recebedor não pode ser nulo") Long payee) {}
