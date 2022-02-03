package com.daniel.backend.service.impl;

import com.daniel.backend.dto.UserDto;
import com.daniel.backend.entity.RoleEntity;
import com.daniel.backend.entity.UserEntity;
import com.daniel.backend.repository.RoleRepository;
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
import java.util.*;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  @Override
  @Transactional
  public UserDto createUser(UserDto userDto) {
    if (userRepository.findByEmail(userDto.getEmail()) != null)
      throw new RuntimeException("Usuário ja existente");

    userDto.setPublicId(UUID.randomUUID().toString().replace("-", ""));
    userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    userDto.setRegistrationDate(LocalDateTime.now());

    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(userDto, userEntity);

    Collection<RoleEntity> roleEntities = new HashSet<>();

    for (String role : userDto.getRoles()) {
      RoleEntity storedRoleEntity = roleRepository.findByName(role);

      if (role != null) {
        roleEntities.add(storedRoleEntity);
      }
    }

    userEntity.setRoles(roleEntities);

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
