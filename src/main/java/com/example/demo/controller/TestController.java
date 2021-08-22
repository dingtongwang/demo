package com.example.demo.controller;

import com.example.demo.model.Content;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("/hello")
  public ResponseEntity<List<Content>> greeting() throws Exception {
    Content content = Content.builder().id("100").name("test").version("1.0.0").build();
    return ResponseEntity.ok(Arrays.asList(content));
  }
}
