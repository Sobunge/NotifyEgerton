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

    @Column(name = "category")
    @Size(min = 5, max = 20)
    private String category;

    @NotNull
    @Column(name = "email")
    @Size(min = 10, max = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_university")
    private University university;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_universityBrunch")
    private UniversityBrunch universityBrunch;

    @ManyToMany(mappedBy = "user")
    private List<Community> communities;

    @ManyToMany(mappedBy = "users")
    private List<Groups> groups;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "username", referencedColumnName = "username") }, inverseJoinColumns = {
                    @JoinColumn(name = "role", referencedColumnName = "name")
            })
    private List<UserRole> roles;

    public User(@NotNull @Size(min = 3, max = 20) String firstname, @NotNull @Size(min = 3, max = 20) String secondname,
            @NotNull @Size(min = 3, max = 20) String thirdname, @NotNull @Size(min = 4, max = 20) String username,
            @NotNull String password, @NotNull @Size(min = 4, max = 6) String gender,
            @NotNull @Size(min = 10, max = 50) String email) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.thirdname = thirdname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }

}
