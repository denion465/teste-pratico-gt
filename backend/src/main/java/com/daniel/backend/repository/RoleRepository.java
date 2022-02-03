package com.daniel.backend.repository;

import com.daniel.backend.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
  RoleEntity findByName(String name);
}

