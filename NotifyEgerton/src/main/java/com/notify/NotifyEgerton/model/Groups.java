package com.notify.NotifyEgerton.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "grps")
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


    @Column(name = "description")
    private String description;

    @NotNull
    private int count;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "group_users", joinColumns = {
            @JoinColumn(name = "group_id", referencedColumnName = "group_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "username", referencedColumnName = "username")
            })
    private List<User> users;

    @OneToMany(mappedBy = "group")
    private List<Post> posts;

    public void addUser(User user) {
        users.add(user);
    }

}
