package com.daniel.backend.service.impl;

import com.daniel.backend.dto.UserDto;
import com.daniel.backend.entity.UserEntity;
import com.daniel.backend.repository.UserRepository;
import com.daniel.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final UserRepository userRepository;

  @Override
  @Transactional
  public UserDto createUser(UserDto userDto) {
    if (userRepository.findByEmail(userDto.getEmail()) != null)
      throw new RuntimeException("Usuário ja existente");

    userDto.setPublicId(UUID.randomUUID().toString());
    userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    userDto.setRegistrationDate(LocalDateTime.now());

    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(userDto, userEntity);

    UserEntity returnValue = userRepository.save(userEntity);

    BeanUtils.copyProperties(returnValue, userDto);

    return userDto;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserEntity userEntity = userRepository.findByEmail(email);

    if (userEntity == null) throw new UsernameNotFoundException(email);

    return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
  }
}
