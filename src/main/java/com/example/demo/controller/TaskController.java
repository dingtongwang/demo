package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {

  private SimpMessagingTemplate template;

  @PostMapping("/task")
  public void executeTask(String task) {
    template.convertAndSend("/topic/task", task);
  }
}
