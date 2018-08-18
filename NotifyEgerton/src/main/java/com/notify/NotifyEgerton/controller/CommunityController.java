package com.notify.NotifyEgerton.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.notify.NotifyEgerton.model.Community;
import com.notify.NotifyEgerton.model.Post;
import com.notify.NotifyEgerton.model.User;
;
import com.notify.NotifyEgerton.service.CommunityService;
import com.notify.NotifyEgerton.service.PostService;
import com.notify.NotifyEgerton.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @Autowired
    UserService userService;
    
    @Autowired
    PostService postService;

    @RequestMapping("community")
    public String community(Model model, Principal principal) {

        ArrayList<Community> communities = new ArrayList<>();

        User user = userService.findOne(principal.getName());
        communities.addAll(communityService.getAllCommunities());

        model.addAttribute("user", user);
        model.addAttribute("communities", communities);
        model.addAttribute("title", "Uni-Notice");

        if (principal.getName() == null) {

            return "redirect:/login?logout";
        } else {
            return "/community";
        }
    }

    @RequestMapping(value = "createCommunity", method = RequestMethod.GET)
    public String createCommunity(Model model, Principal principal) {

        if (principal.getName() == null) {

            return "redirect:/login?logout";
        } else {

            User user = userService.findOne(principal.getName());

            model.addAttribute("title", "Uni-Notice");
            ArrayList<User> users = new ArrayList<>();

            users.add(user);
            Community community = new Community();
            community.setUser(users);

            model.addAttribute("user", user);
            model.addAttribute("community", community);

            return "/createCommunity";
        }
    }

    @RequestMapping(value = "createCommunity", method = RequestMethod.POST)
    public String processCommunityCreation(@Valid Community community, BindingResult bindingResult, Model model, Principal principal) {
        User user = userService.findOne(principal.getName());

        ArrayList<User> users = new ArrayList<>();

        users.add(user);

        community.setUser(users);
        if (bindingResult.hasErrors()) {
            return "createCommunity";
        }
        if (communityService.isCommunityPresent(community.getName())) {
            model.addAttribute("exists", "The a community with the name " + community.getName() + " already exists!!");
            return "createCommunity";
        }

        
        
        communityService.addCommunity(community);
        model.addAttribute("title", "Uni-Notice");
        model.addAttribute("success", "You have successfully created a community");
        model.addAttribute("user", user);
        return "redirect:/community";

    }

    @RequestMapping("Community/{communityId}")
    public String individualCommunity(Model model, @PathVariable long communityId, Principal principal) {

        if (principal.getName() == null) {
            return "redirect:/login?logout";
        } else {

            Community community = communityService.getCommunity(communityId).get();

            User user = userService.findOne(principal.getName());
            model.addAttribute("community", community);

            ArrayList<Post> posts = new ArrayList<>();
            
            posts = (ArrayList<Post>) postService.getAllPost(communityId);
            
            model.addAttribute("posts", posts);
            model.addAttribute("user", user);
            return "individualCommunity";
        }

    }

    @GetMapping(value = "/Community/{communityId}/join")
    public String joinCommunity(Community community, @PathVariable Long communityId, Principal principal, Model model) {

        User user = userService.findOne(principal.getName());
        
        community = communityService.getCommunity(communityId).get();

        community.addUser(user);
        
        communityService.addCommunity(community);
         
        return "redirect:/community";

    }

}
