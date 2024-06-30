package com.dev.gabriel.desafio_picpay.repository;

import com.dev.gabriel.desafio_picpay.model.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {}
