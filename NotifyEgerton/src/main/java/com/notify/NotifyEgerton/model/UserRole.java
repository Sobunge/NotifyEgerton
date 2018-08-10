package com.notify.NotifyEgerton.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class UserRole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id")
    private long userRoleId;
    
    @Column(name = "username")
    @NotNull
    @Size(min = 8, max = 20)
    private String username;
    
    @Column(name = "role")
    @NotNull
    @Size(min = 4, max = 5)
    private String role;

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    
}
