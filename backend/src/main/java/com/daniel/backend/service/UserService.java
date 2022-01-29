package com.daniel.backend.service;

import com.daniel.backend.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  UserDto createUser(UserDto user);
}
