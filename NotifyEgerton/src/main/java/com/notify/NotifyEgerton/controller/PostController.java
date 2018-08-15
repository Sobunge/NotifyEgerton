package com.notify.NotifyEgerton.controller;

import com.notify.NotifyEgerton.model.Community;
import com.notify.NotifyEgerton.model.Post;
import com.notify.NotifyEgerton.model.User;
import com.notify.NotifyEgerton.service.CommunityService;
import com.notify.NotifyEgerton.service.CustomeUserDetailsService;
import com.notify.NotifyEgerton.service.PostService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    PostService postService;
    
    @Autowired
    CustomeUserDetailsService customeUserDetailsService;
    
    @Autowired
    CommunityService communityService;

    @GetMapping("Community/{communityId}/createPost")
    public String addPost(Model model, Principal principal,@PathVariable Long communityId) {

        Community community = communityService.getCommunity(communityId).get();
        
        Post post = new Post();
        
        post.setCommunity(community);
        model.addAttribute("post", post);
        model.addAttribute("community", community);

        if (principal.getName() == null) {

            return "redirect:/login?logout";
        } else {
            return "postForm";
        }

    }

    @PostMapping("Community/{communityId}/createPost")
    public String processAddPost(@Valid Post post, Model model, @PathVariable Long communityId, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "Community/{communityId}/createPost";
        }
        
        Community community = communityService.getCommunity(communityId).get();

        post.setCommunity(community);
        
        postService.addPost(post);
        model.addAttribute("title", "Uni-Notice");
        model.addAttribute("success", "You have successfully posted a notice");
        
        return "redirect:/community";
    }

}
