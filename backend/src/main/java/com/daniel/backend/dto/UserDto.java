package com.daniel.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
public class UserDto {
  private long id;
  private String publicId;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String encryptedPassword;
  private String phone;
  private LocalDateTime registrationDate;
  private Collection<String> roles;
}
