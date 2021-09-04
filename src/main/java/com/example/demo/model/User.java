package com.example.demo.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @description:
 * @author: tongwang.ding
 * @date: 2021-08-25 20:33
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String firstName;

  private String lastName;

  private String phoneNumber;

  private String email;

  private String roles;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
