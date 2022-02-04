package com.daniel.backend;

import com.daniel.backend.entity.*;
import com.daniel.backend.repository.AuthorityRepository;
import com.daniel.backend.repository.RoleRepository;
import com.daniel.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    createNurseUser(roleNurse);
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

    PersonEnitty doctorPerson = new PersonEnitty();
    doctorPerson.setFirstName("Jose");
    doctorPerson.setLastName("Silva");
    doctorPerson.setCpf("111.111.111-11");
    doctorPerson.setBirthDate(LocalDate.ofEpochDay(1990-10-20));
    doctorPerson.setWeight("90 kg");
    doctorPerson.setHeight("1.80 cm");
    doctorPerson.setPhone("35-99999-9999");

    AddressEntity addressEntity = new AddressEntity();
    addressEntity.setCity("Pouso Alegre");
    addressEntity.setUf("MG");
    addressEntity.setStreetName("Amazonas");
    addressEntity.setPostalCode("37490");

    doctorUser.setPublicId(UUID.randomUUID().toString().replace("-", ""));
    doctorUser.setEmail("admin@clinica.com");
    doctorUser.setEncryptedPassword(bCryptPasswordEncoder.encode("123456"));
    doctorUser.setRegistrationDate(LocalDateTime.now());
    doctorUser.setRoles(List.of(roleDoctor));

    doctorPerson.setAddresses(addressEntity);
    doctorPerson.setUserEntity(doctorUser);
    doctorUser.setPersonEnitty(doctorPerson);

    UserEntity storedDoctorUSer = userRepository.findByEmail("admin@clinica.com");

    if (storedDoctorUSer == null) {
      userRepository.save(doctorUser);
    }
  }

  @Transactional
  private void createNurseUser(RoleEntity roleNurse) {
    UserEntity nurseUser = new UserEntity();

    PersonEnitty nursePerson = new PersonEnitty();
    nursePerson.setFirstName("Fernanda");
    nursePerson.setLastName("Lima");
    nursePerson.setCpf("222.222.222-22");
    nursePerson.setBirthDate(LocalDate.ofEpochDay(1995-10-20));
    nursePerson.setWeight("70 kg");
    nursePerson.setHeight("1.50 cm");
    nursePerson.setPhone("35-88888-8888");

    AddressEntity addressEntity = new AddressEntity();
    addressEntity.setCity("Varginha");
    addressEntity.setUf("MG");
    addressEntity.setStreetName("São Paulo");
    addressEntity.setPostalCode("37490");

    nurseUser.setPublicId(UUID.randomUUID().toString().replace("-", ""));
    nurseUser.setEmail("nurse@clinica.com");
    nurseUser.setEncryptedPassword(bCryptPasswordEncoder.encode("123456"));
    nurseUser.setRegistrationDate(LocalDateTime.now());
    nurseUser.setRoles(List.of(roleNurse));

    nursePerson.setAddresses(addressEntity);
    nursePerson.setUserEntity(nurseUser);
    nurseUser.setPersonEnitty(nursePerson);

    UserEntity storedNurseUser = userRepository.findByEmail("nurse@clinica.com");

    if (storedNurseUser == null) {
      userRepository.save(nurseUser);
    }
  }
}
