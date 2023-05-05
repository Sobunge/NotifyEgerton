package com.notify.NotifyEgerton.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "community_users", joinColumns = {
            @JoinColumn(name = "community_id", referencedColumnName = "community_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "username", referencedColumnName = "username")
            })
    private List<User> user;

    @OneToMany(mappedBy = "community", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Post> posts;

    public void addUser(User users) {
        user.add(users);
    }

}
