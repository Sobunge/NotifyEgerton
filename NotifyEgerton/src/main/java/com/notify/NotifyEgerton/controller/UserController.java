package com.notify.NotifyEgerton.controller;

import com.notify.NotifyEgerton.model.User;
import com.notify.NotifyEgerton.service.EmailService;
import com.notify.NotifyEgerton.service.UserService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/users")
    public String listUsers(Model model, Principal principal, @RequestParam(defaultValue = "") String username) {

        List<User> users = userService.findByUsername(username);
        User user = userService.findOne(principal.getName());

        List<User> allUsers = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {

            if ( user.getUsername() != (users.get(i).getUsername()) ) {
                allUsers.add(users.get(i));
            }
        }

        model.addAttribute("users", allUsers);

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

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("title", "Uni-Notice");
        model.addAttribute("user", new User());
        return "registration";

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/registration")
    public String registrationProcessing(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (userService.isUserPresent(user.getUsername())) {
            model.addAttribute("exists", "The username already exists");
            return "registration";
        }

        //Sending a notification
        try {
            emailService.sendSimpleMessage(user.getEmail(), "Uni-Notice User Registration",
                    "You have successfull been added as a member of Uni-Notice. "
                    + "Your username is: " + user.getUsername()
                    + " and password is: " + user.getPassword() + ". Please change your password after login.");
        } catch (MailException e) {
            //Catch the error
            e.printStackTrace();
        }
        userService.addUser(user);

        model.addAttribute("success", "You have successfull registered");

        return "/homepage";
    }
    
    @RequestMapping("/delete/{username}")
    public void deleteUser(@PathVariable String username){
    
        User user = userService.findOne(username);
        
        userService.deleteUser(user);
    }

}
