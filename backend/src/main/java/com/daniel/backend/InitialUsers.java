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
public class InitialUsers {
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
    RoleEntity roleNurse = createRole("ROLE_NURSE", Arrays.asList(readAuthority, writeAuthority));
    RoleEntity roleDoctor = createRole("ROLE_DOCTOR", Arrays.asList(readAuthority, writeAuthority, deleteAuthority));

    createDoctorUser(roleDoctor);
    createNuserUser(roleNurse);
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

  @Transactional
  private void createDoctorUser(RoleEntity roleDoctor) {
    UserEntity doctorUser = new UserEntity();

    doctorUser.setPublicId(UUID.randomUUID().toString().replace("-", ""));
    doctorUser.setFirstName("José");
    doctorUser.setLastName("Silva");
    doctorUser.setEmail("admin@clinica.com");
    doctorUser.setEncryptedPassword(bCryptPasswordEncoder.encode("123456"));
    doctorUser.setPhone("35-99999-9999");
    doctorUser.setRegistrationDate(LocalDateTime.now());
    doctorUser.setRoles(List.of(roleDoctor));

    UserEntity storedDoctorUSer = userRepository.findByEmail("admin@clinica.com");

    if (storedDoctorUSer == null) {
      userRepository.save(doctorUser);
    }
  }

  @Transactional
  private void createNuserUser(RoleEntity roleNurse) {
    UserEntity nurseUser = new UserEntity();

    nurseUser.setPublicId(UUID.randomUUID().toString().replace("-", ""));
    nurseUser.setFirstName("Fernanda");
    nurseUser.setLastName("Lima");
    nurseUser.setEmail("nurse@clinica.com");
    nurseUser.setEncryptedPassword(bCryptPasswordEncoder.encode("123456"));
    nurseUser.setPhone("35-88888-8888");
    nurseUser.setRegistrationDate(LocalDateTime.now());
    nurseUser.setRoles(List.of(roleNurse));

    UserEntity storedNurseUser = userRepository.findByEmail("nurse@clinica.com");

    if (storedNurseUser == null) {
      userRepository.save(nurseUser);
    }
  }
}
