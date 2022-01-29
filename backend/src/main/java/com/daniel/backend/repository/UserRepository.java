package com.daniel.backend.repository;

import com.daniel.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {}
