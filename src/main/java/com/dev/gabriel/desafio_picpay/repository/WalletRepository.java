package com.dev.gabriel.desafio_picpay.repository;

import com.dev.gabriel.desafio_picpay.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
  boolean existsByCpfCnpjOrEmail(String cpfCnpj, String email);
}
