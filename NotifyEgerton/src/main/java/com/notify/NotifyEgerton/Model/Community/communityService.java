package com.notify.NotifyEgerton.Model.Community;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class communityService {
    
    @Autowired 
    private communityRepository CommunityRepository;
    
    public List<Community> getAllCommunities(){
    
         List<Community> community = new ArrayList<>();
        CommunityRepository.findAll().forEach(community :: add);
        
        return community;
    }
    
    public Community getCommunity(String id){
        
        Community community  = new Community();
        
                community = CommunityRepository.findById(id).get();
            
            return community;
    }
    
     
    public void addCommunity(Community community){
        CommunityRepository.save(community);
    }
    
    public void updateCommunity(String id, Community community)
    {
        CommunityRepository.save(community);
    }
    
    public void deleteCommunity(String id)
    {
        CommunityRepository.deleteById(id);
    }
    
}
