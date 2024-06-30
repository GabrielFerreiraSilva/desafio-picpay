package com.dev.gabriel.desafio_picpay.dto;

import com.dev.gabriel.desafio_picpay.model.enums.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletRequest(
    @NotBlank(message = "O campo nome não pode ser nulo ou estar em branco") String name,
    @NotBlank(message = "O campo CPF/CNPJ não pode ser nulo ou estar em branco") String cpfCnpj,
    @NotBlank(message = "O campo email não pode ser nulo ou estar em branco") String email,
    @NotBlank(message = "O campo senha não pode ser nulo ou estar em branco") String password,
    @NotNull(message = "O campo tipo de carteira não pode ser nulo") WalletType walletType) {}
