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
public class User {

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "firstname")
    private String firstname;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "secondname")
    private String secondname;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "thirdname")
    private String thirdname;

    @Id
    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "gender")
    @Size(min = 4, max = 6)
    private String gender;

    @NotNull
    @Column(name = "university")
    @Size(min = 3, max = 50)
    private String university;

    @NotNull
    @Column(name = "university_brunch")
    @Size(min = 3, max = 50)
    private String universityBrunch;

    @NotNull
    @Column(name = "category")
    @Size(min = 5, max = 20)
    private String category;

    @NotNull
    @Column(name = "email")
    @Size(min = 10, max = 50)
    private String email;

    @ManyToMany(mappedBy = "user")
    private List<Community> communities;
    
    @ManyToMany(mappedBy = "users")
    private List<Groups> groups;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles" , joinColumns = {
        @JoinColumn(name = "username", referencedColumnName = "username")}, inverseJoinColumns = {
        @JoinColumn(name = "role", referencedColumnName = "name")
        })
    private List<UserRole> roles;
    
}
