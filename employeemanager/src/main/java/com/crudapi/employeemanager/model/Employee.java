package com.crudapi.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String email;
    private String name;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeeCode;
    
    public Employee(){}
    public Employee(Long id, String email, String name, String jobTitle, String phone, String imageUrl, String employeeCode) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }
    
    public Long getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public String getJobTitle(){
        return jobTitle;
    }
    public String getPhone(){
        return phone;
    }
    public String getImageUrl(){
        return imageUrl;
    }
    public String getEmployeeCode(){
        return employeeCode;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public void setEmployeeCode(String employeeCode){
        this.employeeCode = employeeCode;
    }
}
