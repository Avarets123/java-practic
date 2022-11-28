package ru.web.firstwebapp.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.web.firstwebapp.dto.UserForm;
import ru.web.firstwebapp.services.UsersService;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;


    @GetMapping("/users")
    public String getUsersPage(
            @RequestParam(value = "orderBy", required = false) String orderBy,
            @RequestParam(value = "dir", required = false) String dir,
            Model model
    ) {
        model.addAttribute("users", usersService.getAllUsers());
        return "users_page";
    }


    @PostMapping("/users")
    public String addUser(UserForm user) {
        usersService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String getUserPage(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("user", usersService.getUser(id));
        return "user_page";
    }


    @PostMapping("/users/{id}/update")
    public String updateUser(
            @PathVariable("id") Long userId,
            UserForm user
    ) {
        usersService.updateUser(userId, user);
        return "redirect:/users/" + userId;
    }

    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable("id") Long userId) {
        usersService.deleteUser(userId);
        return "redirect:/users";
    }

}
