package com.dev.gabriel.desafio_picpay.controller;

import com.dev.gabriel.desafio_picpay.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {
  private final TransferService transferService;
}
