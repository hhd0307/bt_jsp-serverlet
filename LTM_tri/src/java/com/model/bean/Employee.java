/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.bean;
/**
 *
 * @author Nguyen Tri
 */
public class Employee {
    int employeeId;
    String username;
    String password;
    String address;
    public Employee(){
        
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee(int employeeId, String username, String password, String address) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.address = address;
    }
    
    
}
