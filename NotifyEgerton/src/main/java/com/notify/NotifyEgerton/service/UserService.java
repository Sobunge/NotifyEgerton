package com.notify.NotifyEgerton.service;

import com.notify.NotifyEgerton.model.User;
import com.notify.NotifyEgerton.model.UserRole;
import com.notify.NotifyEgerton.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sobunge
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        UserRole role = new UserRole("USER");
        
        List<UserRole> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        
        userRepository.save(user);
        
    }
    
    public void deleteUser(String username){
    
     userRepository.deleteById(username);
    }
    
    public void addAdmin(User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        UserRole role = new UserRole("ADMIN");
        
        List<UserRole> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        
        userRepository.save(user);
        
    }
    
    public User findOne(String username){
    
        return userRepository.findByUsername(username).get();
    }
    
    public Boolean isUserPresent(String username){
    
        return userRepository.existsById(username);
    }
    
   
    public List<User> findAll(){
    
        return (List<User>) userRepository.findAll();
    }

    public List<User> findByUsername(String username) {
        
        return userRepository.findByUsernameLike("%" + username + "%");
    }

 
}
