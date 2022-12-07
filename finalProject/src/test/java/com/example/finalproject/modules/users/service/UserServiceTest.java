package com.example.finalproject.modules.users.service;

import com.example.finalproject.modules.users.entity.UserEntity;

import com.example.finalproject.modules.users.repository.UserRepository;
import com.example.finalproject.modules.users.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;



class UserServiceTest {

    private static final Long EXISTED_USER_ID = 1L;
    private static final Long NOT_EXISTED_USER_ID = 2L;
    private static final UserEntity USER = existedUser();
    private UserService userService;
    private UserRepository userRepository;


    private void addMocks() {
        this.userRepository = Mockito.mock(UserRepository.class);

    }

    private void addBehavior() {
        Mockito.when(userService.getUserById(EXISTED_USER_ID)).thenReturn(existedUser());
        Mockito.when(userService.getUserById(NOT_EXISTED_USER_ID)).thenReturn(UserEntity.builder().build());
        Mockito.when(userService.getAllUsers()).thenReturn(List.of(USER, USER, USER));
    }

    private static UserEntity existedUser() {
        return UserEntity.builder()
                .state(UserEntity.State.ACTIVE)
                .role(UserEntity.Role.USER)
                .email("test@gmail.com")
                .id(1L)
                .name("tester")
                .password("123")
                .build();
    }

    @BeforeEach
    void setUp() {
        addMocks();
        this.userService = new UserServiceImpl(userRepository);
        addBehavior();
    }

    @Test
    public void getUserByIdIsExist() {
        assertEquals(USER, userService.getUserById(EXISTED_USER_ID));
    }

    @Test
    public void getAllUsers() {
        assertEquals(List.of(USER, USER, USER), userService.getAllUsers());
    }
}