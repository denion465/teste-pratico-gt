package com.daniel.backend;

import com.daniel.backend.entity.AuthorityEntity;
import com.daniel.backend.entity.RoleEntity;
import com.daniel.backend.entity.UserEntity;
import com.daniel.backend.repository.AuthorityRepository;
import com.daniel.backend.repository.RoleRepository;
import com.daniel.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Component
@RequiredArgsConstructor
public class InitialAdminUsers {
  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final RoleRepository roleRepository;
  private final AuthorityRepository authorityRepository;

  @EventListener
  @Transactional
  public void onAppStarted(ApplicationReadyEvent event) {
    AuthorityEntity readAuthority = createAuthority("READ_AUTHORITY");
    AuthorityEntity writeAuthority = createAuthority("WRITE_AUTHORITY");
    AuthorityEntity deleteAuthority = createAuthority("DELETE_AUTHORITY");

    createRole("ROLE_PATIENT", List.of(readAuthority));
    createRole("ROLE_NURSE", Arrays.asList(readAuthority, writeAuthority));
    RoleEntity roleAdmin = createRole("ROLE_DOCTOR", Arrays.asList(readAuthority, writeAuthority, deleteAuthority));


    UserEntity adminUser = new UserEntity();

    adminUser.setPublicId(UUID.randomUUID().toString().replace("-", ""));
    adminUser.setFirstName("José");
    adminUser.setLastName("Silva");
    adminUser.setEmail("admin@clinica.com");
    adminUser.setEncryptedPassword(bCryptPasswordEncoder.encode("123456"));
    adminUser.setPhone("35-99999-9999");
    adminUser.setRegistrationDate(LocalDateTime.now());
    adminUser.setRoles(List.of(roleAdmin));

    UserEntity soteredAdminUser = userRepository.findByEmail("admin@clinica.com");

    if (soteredAdminUser == null) {
      userRepository.save(adminUser);
    }
  }

  @Transactional
  private AuthorityEntity createAuthority(String name) {
    AuthorityEntity authority = authorityRepository.findByName(name);

    if (authority == null) {
      authority = new AuthorityEntity(name);
      authorityRepository.save(authority);
    }

    return authority;
  }

  @Transactional
  private RoleEntity createRole(String name, Collection<AuthorityEntity> authorities) {
    RoleEntity role = roleRepository.findByName(name);

    if (role == null) {
      role = new RoleEntity(name);
      role.setAuthorities(authorities);
      roleRepository.save(role);
    }

    return role;
  }
}
