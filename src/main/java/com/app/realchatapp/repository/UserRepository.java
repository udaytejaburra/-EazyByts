package com.app.realchatapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.realchatapp.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}