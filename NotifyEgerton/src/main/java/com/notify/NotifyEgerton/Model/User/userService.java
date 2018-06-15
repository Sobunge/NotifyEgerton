package com.notify.NotifyEgerton.Model.User;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    
    @Autowired
    private userRepository UserRepository;
    
    public List<User> getAllUsers(){
        
        List<User> user = new ArrayList<>();
        UserRepository.findAll().forEach(user :: add);
        
        return user;
    }
    
    public Optional<User> getUser(String username){
        
            return UserRepository.findById(username);
            
    }
    
    public void addUser(User user){
        UserRepository.save(user);
    }
    
    public void updateUser(String username, User user)
    {
        UserRepository.save(user);
    }
    
    public void deleteUser(String username)
    {
        UserRepository.deleteById(username);
    }
    
}
