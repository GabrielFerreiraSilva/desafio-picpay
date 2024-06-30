package com.dev.gabriel.desafio_picpay.service;

import com.dev.gabriel.desafio_picpay.client.NotificationClient;
import com.dev.gabriel.desafio_picpay.model.entity.Transfer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
  private final NotificationClient notificationClient;
  private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

  public void sendNotification(Transfer transfer) {
    try {
      logger.info("Sending notification...");
      ResponseEntity<Void> response = this.notificationClient.sendNotification(transfer);

      if (response.getStatusCode().isError()) {
        logger.error("Error while sending notification");
      }
    } catch (Exception e) {
      logger.error("Error while sending notification", e);
    }
  }
}
