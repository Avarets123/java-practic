package com.example.finalproject.modules.users.controller;

import com.example.finalproject.modules.auth.config.details.CustomUserDetails;
import com.example.finalproject.modules.users.entity.UserEntity;
import com.example.finalproject.modules.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {

    @GetMapping
    public String mainPage() {
        return "redirect:/films";
    }
    private final UserService userService;

    @GetMapping("users")
    public String getAllUser(Model model) {
         model.addAttribute("users", userService.getAllUsers());
         return "users/users_page";
    }

    @GetMapping("users/{id}")
    public UserEntity getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }


    @GetMapping("profile")
    public String profilePage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("profile", userService.getUserById(userDetails.getUser().getId()));
        return "users/profile_page";
    }

    @GetMapping("users/{id}/delete")
    public String deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }

}
