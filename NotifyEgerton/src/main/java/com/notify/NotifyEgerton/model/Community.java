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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Community {

    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "community_id")
    private Long communityId;

    @NotNull
    @Column(name = "icon")
    @Lob
    private byte[] icon;

    @NotNull
    @Size(min = 6, max = 8)
    @Column(name = "privacy")
    private String privacy;

    @NotNull
    @Size(min = 8, max = 200)
    @Column(name = "description")
    private String description;

    @NotNull
    private int count;
   
    @ManyToMany
    private List<User> user;
    
    @OneToMany(mappedBy = "community")
    private List<Post> posts;

    public void addUser(User users){
        user.add(users);
    }

}
