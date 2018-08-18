package com.notify.NotifyEgerton.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notify.NotifyEgerton.model.Groups;
import com.notify.NotifyEgerton.model.Post;
import com.notify.NotifyEgerton.model.User;
import com.notify.NotifyEgerton.service.GroupService;
import com.notify.NotifyEgerton.service.PostService;
import com.notify.NotifyEgerton.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping("group")
    public String group(Model model, Principal principal) {

        ArrayList<Groups> group = new ArrayList<>();

        group.addAll(groupService.getAllGroups());

        model.addAttribute("user", userService.findOne(principal.getName()));
        model.addAttribute("groups", group);
        model.addAttribute("title", "Uni-Notice");

        if (principal.getName() == null) {

            return "redirect:/login?logout";
        } else {
            return "/group";
        }

    }

    @GetMapping("createGroup")
    public String createGroup(Model model, Principal principal) {

        if (principal.getName() == null) {

            return "redirect:/login?logout";
        } else {
             
            User user = userService.findOne(principal.getName());

            ArrayList<User> users = new ArrayList<>();

            users.add(user);
            Groups groups = new Groups();
            groups.setUsers(users);

            model.addAttribute("user", user);
            model.addAttribute("title", "Uni-Notice");
            model.addAttribute("groups", groups);

            return "/createGroup";
        }

    }

    @PostMapping("createGroup")
    public String processGroupCreation(@Valid Groups group, BindingResult bindingResult, Model model, Principal principal) {

        User user = userService.findOne(principal.getName());

        ArrayList<User> users = new ArrayList<>();

        users.add(user);

        group.setUsers(users);

        if (bindingResult.hasErrors()) {
            return "createGroup";
        }
        if (groupService.isGroupPresent(group.getName())) {
            model.addAttribute("exists", "The a group with the name " + group.getName() + " already exists!!");
            return "createGroup";
        }

        try {

            groupService.addGroup(group);
            model.addAttribute("title", "Uni-Notice");
            model.addAttribute("success", "You have successfully created a group");
            model.addAttribute("user", user);
            return "redirect:/group";
        } catch (Exception e) {

            model.addAttribute("fail", "FAIL! Maybe You had uploaded the file before or the file's size > 500KB");
            return "createGroup";

        }
    }

    @RequestMapping("Group/{groupId}")
    public String individualGroup(Model model, @PathVariable long groupId, Principal principal) {

        if (principal.getName() == null) {
            return "redirect:/login?logout";
        } else {

            Groups group = groupService.getGroup(groupId).get();

            User user = userService.findOne(principal.getName());
            
            model.addAttribute("group", group);

            ArrayList<Post> posts = new ArrayList<>();

            posts = (ArrayList<Post>) postService.getAllGroupPost(groupId);

            model.addAttribute("posts", posts);
            model.addAttribute("user", user);

            return "individualGroup";
        }

    }

    @GetMapping(value = "/Group/{groupId}/join")
    public String joinGroup(Groups group, @PathVariable Long groupId, Principal principal, Model model) {

        User user = userService.findOne(principal.getName());

        group = groupService.getGroup(groupId).get();

        group.addUser(user);

        groupService.addGroup(group);

        return "redirect:/community";

    }

}
