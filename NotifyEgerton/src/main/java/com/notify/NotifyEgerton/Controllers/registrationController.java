
package com.notify.NotifyEgerton.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class registrationController {
    
    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }
}
