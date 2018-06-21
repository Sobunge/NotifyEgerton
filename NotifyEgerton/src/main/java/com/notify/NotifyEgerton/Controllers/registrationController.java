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
public class registrationController {

    @Autowired
    private userService UserService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }
    
    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String processRegistrationForm(@RequestParam String firstname,
            String secondname, String thirdname, String username, String password,
            String gender, String email, String category, Model model) {

        
        
        model.addAttribute("title", "NotifyEgerton");
        model.addAttribute("success", "You have registered successfully,login");

        User user = new User(firstname, secondname, thirdname, username, 
                password, gender, category, email);
        
        UserService.addUser(user);
        
        return "login";
    }

}
