package com.example.finalproject.modules.users.dto;


import com.example.finalproject.modules.users.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateDto {

    private String email;

    private String password;

    private UserEntity.Role role;


}
