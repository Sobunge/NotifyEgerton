package com.notify.NotifyEgerton.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserRole {
    
    @Id
    private String name;
    
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public UserRole(String name) {
        this.name = name;
    }
    
}
