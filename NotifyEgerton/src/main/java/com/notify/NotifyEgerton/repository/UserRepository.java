package com.notify.NotifyEgerton.repository;

import org.springframework.data.repository.CrudRepository;

import com.notify.NotifyEgerton.model.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, String >{
    
    public Optional<User> findByUsername(String username);

    public List<User> findByUsernameLike(String username);
    
}
