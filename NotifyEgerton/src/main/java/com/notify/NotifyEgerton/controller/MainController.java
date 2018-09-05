package com.notify.NotifyEgerton.controller;

import com.notify.NotifyEgerton.model.Community;
import com.notify.NotifyEgerton.model.Groups;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notify.NotifyEgerton.model.User;
import com.notify.NotifyEgerton.model.UserRole;
import com.notify.NotifyEgerton.service.CommunityService;
import com.notify.NotifyEgerton.service.GroupService;
import com.notify.NotifyEgerton.service.PostService;
import com.notify.NotifyEgerton.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
public class MainController {

    @Autowired
    CommunityService communityService;

    @Autowired
    GroupService groupService;

    @Autowired
    PostService postService;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "Uni-Notice");

        return "/index";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/homepage")
    public String homepage(Model model, Principal principal) {

        model.addAttribute("title", "Uni-Notice");

        ArrayList<Community> communities = new ArrayList<>();
        ArrayList<Groups> groups = new ArrayList<>();

        groups.addAll(groupService.getAllGroups(principal.getName()));
        communities.addAll(communityService.getAllCommunities(principal.getName()));

        
        model.addAttribute("groups", groups);
        model.addAttribute("communities", communities);

        if (principal.getName() == null) {

            return "redirect:/login?logout";
        } else {
            return "/homepage";
        }

    }

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping("/userHomepage")
    public String userHomepage(Model model, Principal principal) {

        ArrayList<Community> communities = new ArrayList<>();

        communities.addAll(communityService.getAllCommunities(principal.getName()));
        model.addAttribute("communities", communities);

        ArrayList<Groups> groups = new ArrayList<>();

        groups.addAll(groupService.getAllGroups(principal.getName()));
        model.addAttribute("groups", groups);

        if (principal.getName() == null) {

            return "redirect:/login?logout";
        } else {
            return "/userHomepage";
        }
    }

}
