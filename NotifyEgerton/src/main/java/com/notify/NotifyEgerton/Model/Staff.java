package com.notify.NotifyEgerton.Model;

public class Staff extends User {

    private String employeeNumber;
    private String department;

    public Staff(String employeeNumber, String department, String firstName, String secondName, String thirdName, String gender, String phoneNumber, String category, String password, String email) {
        super(firstName, secondName, thirdName, gender, phoneNumber, category, password, email);
        this.employeeNumber = employeeNumber;
        this.department = department;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
