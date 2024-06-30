package com.dev.gabriel.desafio_picpay.service;

import com.dev.gabriel.desafio_picpay.dto.CreateWalletRequest;
import com.dev.gabriel.desafio_picpay.dto.WalletResponse;
import com.dev.gabriel.desafio_picpay.exception.WalletAlreadyRegisteredException;
import com.dev.gabriel.desafio_picpay.exception.WalletNotFoundException;
import com.dev.gabriel.desafio_picpay.model.entity.Wallet;
import com.dev.gabriel.desafio_picpay.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletService {
  private final WalletRepository walletRepository;

  @Transactional
  public WalletResponse createWallet(CreateWalletRequest request) {

    if (this.walletRepository.existsByCpfCnpjOrEmail(request.cpfCnpj(), request.email())) {
      throw new WalletAlreadyRegisteredException("O CPF/CNPJ ou email fornecidos já estão em uso");
    }

    Wallet savedWallet = this.walletRepository.save(new Wallet(request));

    return new WalletResponse(savedWallet);
  }

  @Transactional
  public void credit(Long id, BigDecimal value) {
    Wallet wallet = this.walletRepository.findById(id).orElseThrow(WalletNotFoundException::new);

    wallet.setBalance(wallet.getBalance().add(value));

    this.walletRepository.save(wallet);
  }
}
