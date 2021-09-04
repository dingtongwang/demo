package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @description:
 * @author: tongwang.ding
 * @date: 2021-08-25 21:03
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

  private String firstName;

  private String lastName;

  private String phoneNumber;

  private String email;

  private String roles;
}
