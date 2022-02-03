package com.daniel.backend.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserRest {
  private String publicId;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private LocalDateTime registrationDate;
}
