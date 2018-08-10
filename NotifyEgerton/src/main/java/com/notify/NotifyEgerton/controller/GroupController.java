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
import com.notify.NotifyEgerton.service.GroupService;

@Controller
public class GroupController {

	@Autowired
	GroupService groupService;

	@RequestMapping("group")
	public String group(Model model, Principal principal) {

		ArrayList<Groups> group = new ArrayList<>();

		group.addAll(groupService.getAllGroups());

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

		model.addAttribute("title", "Uni-Notice");
		model.addAttribute("groups", new Groups());

		if (principal.getName() == null) {

			return "redirect:/login?logout";
		} else {
			return "/createGroup";
		}
	}

	@PostMapping("createGroup")
	public String processGroupCreation(@Valid Groups group, BindingResult bindingResult, Model model) {

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
			return "redirect:/group";
		} catch (Exception e) {

			model.addAttribute("fail", "FAIL! Maybe You had uploaded the file before or the file's size > 500KB");
			return "createGroup";

		}
	}

}
