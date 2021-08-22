package com.example.demo.controller;

import java.security.Principal;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  @MessageMapping("/chat")
  @SendToUser("/queue/trade")
  public String processTrade(@Payload String message, Principal principal) {
    return null;
  }
}
