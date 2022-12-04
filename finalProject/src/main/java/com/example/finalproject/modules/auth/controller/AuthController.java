package com.example.finalproject.modules.auth.controller;


import com.example.finalproject.modules.users.dto.UserCreateDto;
import com.example.finalproject.modules.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AuthController {
    private final UserService userService;

    @GetMapping("/signIn")
    public String signIn(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/films";
        }
        return "auth/signIn_page";
    }

    @GetMapping("/signUp")
    public String signUp(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/films";
        }
        return "auth/signUp_page";
    }

    @PostMapping("/signUp")
    public String registration(UserCreateDto userCreateDto) {
        userService.saveUser(userCreateDto);
        return "redirect:/signIn";
    }
}
