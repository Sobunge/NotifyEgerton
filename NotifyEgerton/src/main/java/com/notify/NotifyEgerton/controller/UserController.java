package com.notify.NotifyEgerton.controller;

import com.notify.NotifyEgerton.model.User;
import com.notify.NotifyEgerton.service.UserService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public String listUsers(Model model,@RequestParam(defaultValue = "") String username) {
        
        model.addAttribute("users", userService.findByUsername(username));
        
        return "users";
    }

    @RequestMapping("/profile")
    public String profile(Model model, Principal principal) {

        if (principal.getName() == null) {
            return "redirect:/login?logout";
        } else {
            User user = userService.findOne(principal.getName());

            model.addAttribute("user", user);

            return "/profile";
        }
    }
    
            @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("title", "Uni-Notice");
        model.addAttribute("user", new User());
        return "registration";
        
    }

    
    @PostMapping("/registration")
    public String registrationProcessing(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (userService.isUserPresent(user.getUsername())) {
            model.addAttribute("exists", "The username already exists");
            return "registration";
        }

        userService.addAdmin(user);

        model.addAttribute("success", "You have successfull registered");

        return "/homepage";
    }

}


