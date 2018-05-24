package com.model.dao;

import com.model.bean.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Tri
 */
public class EmployeeDao {
    
    //connect
    String url = "jdbc:sqlserver://localhost:1433;databaseName=TestJava4";
    String userName = "sa";
    String password = "123";
    Connection connection;

    void connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, userName, password);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public boolean checkLogin(String username, String password) {
        connect();
        String sql = String.format("SELECT Name FROM Employee WHERE Name = '%s' AND Password = '%s'", username, password);
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Employee> listEmployee() {
        connect();
        String sql = "select * from Employee";
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<Employee> list = new ArrayList<Employee>();
        Employee employee;
        try {
            while (rs.next()) {
                employee = new Employee();
                employee.setEmployeeId(rs.getInt("EmployeeId"));
                employee.setUsername(rs.getString("Name"));
                employee.setPassword(rs.getString("Password"));
                employee.setAddress(rs.getString("Address"));
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addEmployee(String name, String pass, String address) {
        connect();
        String sql = String.format("Insert into Employee (Name,Password,Address) values (N'%s',N'%s',N'%s')", name, pass, address);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        connect();
        String sql = String.format("delete from Employee where EmployeeId= '%d'", id);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getInfomationEmployee(int id) {
        connect();
        String sql = String.format("select Name,Password,Address from Employee where EmployeeId = '%d'", id);
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Employee emp = new Employee();
        try {
            while (rs.next()) {
                emp.setEmployeeId(id);
                emp.setUsername(rs.getString("Name"));
                emp.setPassword(rs.getString("Password"));
                emp.setAddress(rs.getString("Address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    public void editEmployee(int id, String name, String pass, String address) {
        connect();
        String sql = String.format("update Employee set Name = N'%s',Password = N'%s',Address = N'%s'where EmployeeId = '%d' ", name, pass, address, id);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //search
    public ArrayList<Employee> getListEmployee(String name) {
        connect();
        String sql = "Select * from Employee where Name = '" + name + "' ";
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Employee> list = new ArrayList<Employee>();
        Employee employee = new Employee();
        try {
            while (rs.next()) {

                employee.setEmployeeId(rs.getInt("EmployeeId"));
                employee.setUsername(name);
                employee.setPassword(rs.getString("Password"));
                employee.setAddress(rs.getString("Address"));
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
