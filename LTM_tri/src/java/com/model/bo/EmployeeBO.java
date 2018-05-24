/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.bo;

import com.model.bean.Employee;
import com.model.dao.EmployeeDao;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Tri
 */
public class EmployeeBO {
    EmployeeDao employeeDAO = new EmployeeDao();
    
    public boolean checkLogin(String username, String password) {
        return employeeDAO.checkLogin(username, password);
    }
    public ArrayList<Employee> listEmployee() {
        return employeeDAO.listEmployee();
    }
    public void addEmployee(String name ,String pass,String address){
        employeeDAO.addEmployee(name, pass, address);
    }
    public  void deleteEmployee(int id){
        employeeDAO.deleteEmployee(id);
    }
    public Employee getInfomationEmployee(int id){
        return employeeDAO.getInfomationEmployee(id);
    }
    public void editEmployee(int id,String name,String pass,String address){
        employeeDAO.editEmployee(id,name, pass, address);
    }
    //search
    public  ArrayList<Employee> getListEmployee(String name){
        return employeeDAO.getListEmployee(name);
    }
}
