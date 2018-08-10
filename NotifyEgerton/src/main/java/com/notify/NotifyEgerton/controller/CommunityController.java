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

import com.notify.NotifyEgerton.model.Community;;
import com.notify.NotifyEgerton.service.CommunityService;

@Controller
public class CommunityController {

	@Autowired
	CommunityService communityService;


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

	@GetMapping("createCommunity")
	public String createCommunity(Model model, Principal principal) {

		model.addAttribute("title", "Uni-Notice");
		model.addAttribute("community", new Community());

		if (principal.getName() == null) {

			return "redirect:/login?logout";
		} else {
			return "/createCommunity";
		}
	}

	@PostMapping("createCommunity")
	public String processCommunityCreation(@Valid Community community, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "createCommunity";
		}
		if (communityService.isCommunityPresent(community.getName())) {
			model.addAttribute("exists", "The a community with the name " + community.getName() + " already exists!!");
			return "createCommunity";
		}

		try {

			communityService.addCommunity(community);
			model.addAttribute("title", "Uni-Notice");
			model.addAttribute("success", "You have successfully created a community");
			return "redirect:/community";
		} catch (Exception e) {

			model.addAttribute("fail", "FAIL! Maybe You had uploaded the file before or the file's size > 500KB");
			return "createCommunity";

		}
	}

	@RequestMapping("individualCommunity/{communityId}")
	public String individualCommunity(Model model, @PathVariable long communityId, Principal principal,@RequestParam(defaultValue = "0") int page) {

		if (principal.getName() == null) {
			return "redirect:/login?logout";
		} else {

			Community community = new Community();

			community = communityService.getCommunity(communityId).get();

			model.addAttribute("community", community);

			return "individualCommunity";
		}

	}

}
