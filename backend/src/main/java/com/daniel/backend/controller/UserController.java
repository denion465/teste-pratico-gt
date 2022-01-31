package com.daniel.backend.controller;

import com.daniel.backend.dto.UserDto;
import com.daniel.backend.model.request.UserRequest;
import com.daniel.backend.model.response.UserRest;
import com.daniel.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {
  private final UserService userService;

  @PostMapping("/signup")
  public UserRest createUser(@RequestBody UserRequest userRequest) throws Exception {
    UserDto userDto = new UserDto();
    UserRest userRest = new UserRest();

    BeanUtils.copyProperties(userRequest, userDto);
    userDto.setRoles(new HashSet<>(List.of("ROLE_PATIENT")));

    UserDto returnResponse = userService.createUser(userDto);

    BeanUtils.copyProperties(returnResponse, userRest);

    return userRest;
  }
}
