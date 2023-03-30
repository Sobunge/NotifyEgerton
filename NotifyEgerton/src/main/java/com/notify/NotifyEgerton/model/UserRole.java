package com.notify.NotifyEgerton.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserRole {
    
    @Id
    private String name;
    
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public UserRole(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public UserRole(String name) {
        this.name = name;
    }

    public UserRole() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    
}
