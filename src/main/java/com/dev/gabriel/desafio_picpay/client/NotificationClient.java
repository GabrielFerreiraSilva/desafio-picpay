package com.dev.gabriel.desafio_picpay.client;

import com.dev.gabriel.desafio_picpay.model.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification_client", url = "${client.notification-service.url}")
public interface NotificationClient {

  @PostMapping
  ResponseEntity<Void> sendNotification(@RequestBody Transfer transfer);
}
