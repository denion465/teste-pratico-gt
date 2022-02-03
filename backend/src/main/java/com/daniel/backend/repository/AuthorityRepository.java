package com.daniel.backend.repository;

import com.daniel.backend.entity.AuthorityEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<AuthorityEntity, Long> {
  AuthorityEntity findByName(String name);
}
