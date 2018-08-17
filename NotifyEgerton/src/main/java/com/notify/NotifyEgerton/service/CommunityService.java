package com.notify.NotifyEgerton.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notify.NotifyEgerton.model.Community;
import com.notify.NotifyEgerton.model.User;
import com.notify.NotifyEgerton.repository.CommunityRepository;
import sun.security.krb5.internal.ktab.KeyTabConstants;


@Service
public class CommunityService{

	@Autowired
	CommunityRepository communityRepository;

	
       public List<Community> getAllCommunities(String username){
    
           
           List<Community> community = new ArrayList<>();
           communityRepository.findByUser_Username(username)
                   .forEach(community ::  add);
           
           return community;
       }
       
       public List<Community> getAllCommunities(Long communityId){
		
		List<Community> community =new ArrayList<>();
		
		communityRepository.findAllBycommunityId(communityId)
                        .forEach(community :: add);
		
		return community;
	}
	
	public List<Community> getAllCommunities(){
		
		List<Community> community =new ArrayList<>();
		
		communityRepository.findAll().forEach(community::add);
		
		return community;
	}
	
	public void addCommunity(Community community) {
		communityRepository.save(community);
	}
	
	public Optional<Community> getCommunity(long id){

		return communityRepository.findById(id);
		
	}
	
	public boolean isCommunityPresent(String name) {
	
		return communityRepository.existsByName(name);
	}

}
