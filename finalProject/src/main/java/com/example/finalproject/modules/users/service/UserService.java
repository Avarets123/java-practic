package com.example.finalproject.modules.users.service;

import com.example.finalproject.modules.users.dto.UserCreateDto;
import com.example.finalproject.modules.users.dto.UserUpdateDto;
import com.example.finalproject.modules.users.entity.UserEntity;

import java.util.List;

public interface UserService {

    void saveUser(UserCreateDto user);

    UserEntity getUserById(Long userId);

    List<UserEntity> getAllUsers();

    void deleteUser(Long userId);

    void updateUser(Long userId, UserUpdateDto userData);
}
