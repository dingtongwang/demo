package com.example.demo.service;

import com.example.demo.message.BasicMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PushMessages {

  private String topic;
  private BasicMessage message;

  private SimpMessagingTemplate simpMessagingTemplate;

  private void sendMessageWithFixedRate(String topic, BasicMessage message) {
    this.topic = topic;
    this.message = message;
    sendMessage();
  }

//  @Scheduled(fixedRate = 5000)
  private void sendMessage() {
    simpMessagingTemplate.convertAndSend(topic, message);
  }
}
