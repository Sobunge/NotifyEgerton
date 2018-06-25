package com.notify.NotifyEgerton.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class groupController {
    
    @RequestMapping("group")
    public String group(Model model){
        
        model.addAttribute("title", "NotifyEgerton");
        return "group";
    }
}
