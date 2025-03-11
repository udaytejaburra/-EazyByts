package com.app.realchatapp.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.realchatapp.dto.UserDto;
import com.app.realchatapp.service.UserAccountService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserRegistrationController {

    private final UserAccountService userService;

    public UserRegistrationController(UserAccountService userService) {
        this.userService = userService;
    }
    @GetMapping("/signup")
    public String showForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "signup";
    }
    
    
    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserDto userDto, Model model, HttpServletRequest request) {
        try {
            userService.createUserAccount(userDto);
            
            // Manually authenticate user after registration
            request.getSession().setAttribute("username", userDto.getUsername());
            
            return "redirect:/chat"; // Redirect to chat after successful signup
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Username already exists!");
            return "signup"; // Show error on signup page
        }
    }
}