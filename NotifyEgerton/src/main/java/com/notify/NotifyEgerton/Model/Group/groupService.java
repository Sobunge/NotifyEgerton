package com.notify.NotifyEgerton.Model.Group;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class groupService {
    
        @Autowired 
    private groupRepository GroupRepository;
    
    public List<Group> getAllCommunities(){
    
         List<Group> group = new ArrayList<>();
        GroupRepository.findAll().forEach(group :: add);
        
        return group;
    }
    
    public Group getGroup(String id){
        
        Group group  = GroupRepository.findById(id).get();
            
            return group;
    }
    
     
    public void addGroup(Group group){
        GroupRepository.save(group);
    }
    
    public void updateGroup(String id, Group group)
    {
        GroupRepository.save(group);
    }
    
    public void deleteGroup(String id)
    {
        GroupRepository.deleteById(id);
    }
    
}
