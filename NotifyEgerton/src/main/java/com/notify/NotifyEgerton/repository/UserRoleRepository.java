package com.notify.NotifyEgerton.repository;

import org.springframework.data.repository.CrudRepository;

import com.notify.NotifyEgerton.model.UserRole;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole, String>{
    
    public List<String> findRoleByUsername(String username);
}
