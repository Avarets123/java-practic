package com.example.finalproject.modules.users.service.impl;

import com.example.finalproject.modules.users.dto.UserCreateDto;
import com.example.finalproject.modules.users.dto.UserUpdateDto;
import com.example.finalproject.modules.users.entity.UserEntity;
import com.example.finalproject.modules.users.repository.UserRepository;
import com.example.finalproject.modules.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void saveUser(UserCreateDto user) {

        UserEntity newUser = UserEntity.builder()
                .email(user.getEmail())
                .role(user.getRole())
                .state(UserEntity.State.ACTIVE)
                .build()
                .setPassword(user.getPassword());
        userRepository.save(newUser);
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return userRepository.findByIdAndStateNot(userId, UserEntity.State.DELETED);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAllByStateNot(UserEntity.State.DELETED);
    }

    @Override
    public void deleteUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        user.setState(UserEntity.State.DELETED);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long userId, UserUpdateDto userData) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        user.setName(userData.getName() != null ? userData.getName() : user.getName());
        if (userData.getPassword() != null) user.setPassword(userData.getPassword());
        userRepository.save(user);
    }
}
