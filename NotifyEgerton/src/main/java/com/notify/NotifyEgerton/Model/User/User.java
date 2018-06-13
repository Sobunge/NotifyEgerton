package com.notify.NotifyEgerton.Model.User;

import javax.persistence.*;

@Entity
public class User {

    
    private String firstName;
    private String secondName;
    private String thirdName;
    
    @Id
    private String username;
    private String password;
    private String gender;
    private String category;
    private String email;

    public User() {
    }

    public User(String firstName, String secondName, String thirdName, String username, String password, String gender, String category, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.category = category;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
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

}
