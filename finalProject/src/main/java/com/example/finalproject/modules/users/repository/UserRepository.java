package com.example.finalproject.modules.users.repository;

import com.example.finalproject.modules.users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailAndStateNot(String email, UserEntity.State state);
    List<UserEntity> findAllByStateNot(UserEntity.State state);
    UserEntity findByIdAndStateNot(Long userId, UserEntity.State state);
}
