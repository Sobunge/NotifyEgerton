package com.notify.NotifyEgerton.model;

import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;

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

    @OneToMany(mappedBy = "user")
    private Collection<Community> community;

    public User() {
    }

    public User(User user) {

        this.firstname = user.firstname;
        this.secondname = user.secondname;
        this.thirdname = user.thirdname;
        this.username = user.username;
        this.password = user.password;
        this.gender = user.gender;
        this.university = user.university;
        this.universityBrunch = user.universityBrunch;
        this.category = user.category;
        this.email = user.email;
        this.community = user.community;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUniversityBrunch() {
        return universityBrunch;
    }

    public void setUniversityBrunch(String universityBrunch) {
        this.universityBrunch = universityBrunch;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Community> getCommunity() {
        return community;
    }

    public void setCommunity(Collection<Community> community) {
        this.community = community;
    }

}
