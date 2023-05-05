package com.notify.NotifyEgerton.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "groups")
public class Groups {

    @NotNull
    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long groupId;

    @NotNull
    @Column(name = "icon")
    @Lob
    private byte[] icon;

    @NotNull
    @Column(name = "privacy")
    private String privacy;

    @NotNull
    @Column(name = "description")
    private String description;

    @ManyToMany
    private List<User> users;
    
    @OneToMany(mappedBy = "group")
    private List<Post> posts;
    
    @NotNull
    private int count;

    public void addUser(User user){
        users.add(user);
    }
    
}
