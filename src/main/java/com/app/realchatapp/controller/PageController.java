package com.app.realchatapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }
   
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/group-chat")
    public String groupChatPage() {
        return "group";
    }

    @GetMapping("/chat")
    public String chatInterface(Model model) {
        return "chatpage";
    }
}