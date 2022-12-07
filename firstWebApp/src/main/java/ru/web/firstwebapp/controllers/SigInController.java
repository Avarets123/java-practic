package ru.web.firstwebapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigInController {

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "signIn_page";
    }
}
