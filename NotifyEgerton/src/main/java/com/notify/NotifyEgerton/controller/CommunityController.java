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
import com.notify.NotifyEgerton.model.User;
;
import com.notify.NotifyEgerton.service.CommunityService;
import com.notify.NotifyEgerton.service.CustomeUserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @Autowired
    CustomeUserDetailsService customeUserDetailsService;

    @RequestMapping("community")
    public String community(Model model, Principal principal) {

        ArrayList<Community> communities = new ArrayList<>();

        communities.addAll(communityService.getAllCommunities());

        model.addAttribute("communities", communities);
        model.addAttribute("title", "Uni-Notice");

        if (principal.getName() == null) {

            return "redirect:/login?logout";
        } else {
            return "/community";
        }
    }

    @RequestMapping(value="createCommunity", method = RequestMethod.GET)
    public String createCommunity(Model model, Principal principal) {

        if (principal.getName() == null) {

            return "redirect:/login?logout";
        } else {

            User user = customeUserDetailsService.activeUser(principal.getName());
            
            model.addAttribute("title", "Uni-Notice");

            Community community = new Community();
            community.setUser(user);
            
            model.addAttribute("community", community);

            return "/createCommunity";
        }
    }

    @RequestMapping(value = "createCommunity", method = RequestMethod.POST)
    public String processCommunityCreation(@Valid Community community, BindingResult bindingResult, Model model,Principal principal) {
        User user = customeUserDetailsService.activeUser(principal.getName());
        community.setUser(user);
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
        return "redirect:/community";

    }

    @RequestMapping("Community/{communityId}")
    public String individualCommunity(Model model, @PathVariable long communityId, Principal principal, @RequestParam(defaultValue = "0") int page) {

        if (principal.getName() == null) {
            return "redirect:/login?logout";
        } else {

            Community community = communityService.getCommunity(communityId).get();

            User user = customeUserDetailsService.activeUser(principal.getName());
            model.addAttribute("community", community);

            model.addAttribute("user", user);
            return "individualCommunity";
        }

    }

    @PostMapping(value = "/Community/{communityId}/user/{username}")
    public String addUserToCommunity(@RequestBody Community community, @PathVariable String username, @PathVariable Long communityId) {

        community = communityService.getCommunity(communityId).get();

        communityService.addCommunity(community);

        return "homepage";
    }
}
