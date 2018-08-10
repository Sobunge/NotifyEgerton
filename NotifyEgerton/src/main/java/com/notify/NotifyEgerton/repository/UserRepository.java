package com.notify.NotifyEgerton.repository;

import org.springframework.data.repository.CrudRepository;

import com.notify.NotifyEgerton.model.User;


public interface UserRepository extends CrudRepository<User, String >{
    
    public User findByUsername(String username);
    
}
