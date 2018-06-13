package com.notify.NotifyEgerton.Model;

public class Student extends User {

    private String registrationNumber;
    private String department;
    private String faculty;

    public Student(String registrationNumber, String department, String faculty, String firstName, String secondName, String thirdName, String gender, String phoneNumber, String category, String password, String email) {
        super(firstName, secondName, thirdName, gender, phoneNumber, category, password, email);
        this.registrationNumber = registrationNumber;
        this.department = department;
        this.faculty = faculty;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

}
