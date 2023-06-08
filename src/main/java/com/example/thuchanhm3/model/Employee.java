package com.example.thuchanhm3.model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone_number;
    private double salary;
    private Department department;

    public Employee() {
    }

    public Employee(int id, String name, String email, String address, String phone_number, double salary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name, String email, String address, String phone_number, double salary, Department department) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
