package com.daniel.backend.service;

import com.daniel.backend.dto.UserDto;

public interface UserService {
  UserDto createUser(UserDto user);
}
