package com.notify.NotifyEgerton.repository;

import com.notify.NotifyEgerton.model.UserRole;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<UserRole, String>{
    
}
