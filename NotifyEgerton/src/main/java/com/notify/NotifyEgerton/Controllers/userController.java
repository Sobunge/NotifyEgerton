package com.notify.NotifyEgerton.Controllers;

import com.notify.NotifyEgerton.Model.User.User;
import com.notify.NotifyEgerton.Model.User.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userController {

    @Autowired
    private userService UserService;

    User user = new User();

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {

        model.addAttribute("title", "NotifyEgerton");
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLoginForm(@RequestParam String username, String password, Model model) {

        if (UserService.getUser(username).isPresent()) {
            user = UserService.getUser(username).get();

            if (user.getPassword().equals(password)) {
                model.addAttribute("username", username);
                return "redirect:/homepage";
            } else {
                model.addAttribute("fail", "The password entered is incorrect");
                return "login";
            }
        } else {
            model.addAttribute("fail", "The username entered does not exist");
            return "login";
        }
    }

    @RequestMapping("homepage")
    public String homepage(Model model) {

        model.addAttribute("user", user);
        model.addAttribute("title", "NotifyEgerton");

        return "homepage";

    }

    @RequestMapping("community")
    public String community(Model model) {

        model.addAttribute("user", user);
        model.addAttribute("title", "NotifyEgerton");
        return "community";
    }

    @RequestMapping("group")
    public String group(Model model) {

        model.addAttribute("user", user);
        model.addAttribute("title", "NotifyEgerton");
        return "group";
    }
}
