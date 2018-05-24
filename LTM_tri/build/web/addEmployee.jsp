<%-- 
    Document   : addEmployee
    Created on : May 5, 2018, 9:50:44 PM
    Author     : Nguyen Tri 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AddEmployee" method="post">
            <table>
                <tr>
                    <td>UserName :</td>
                    <td><input type="text" name="name"></td>        
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><input type="password" name="password"></td>        
                </tr>
                <tr>
                    <td>Address :</td>
                    <td><input type="text" name="address"></td>        
                </tr>
                <tr>
                    <td><button type="submit" value="submit" name="submit">Add</button></td>        
                </tr>
            </table>
        </form>
    </body>
</html>
