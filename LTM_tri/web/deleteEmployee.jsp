<%-- 
    Document   : deleteEmployee
    Created on : May 6, 2018, 8:39:24 AM
    Author     : Nguyen Tri 
--%>

<%@page import="com.model.bean.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Employee employee = (Employee) request.getAttribute("employee");%>
        <h3>Edit Employee :<%=employee.getUsername()%></h3>

        <form action="DeleteEmployee" method="post">

            <table>
                <tr>
                    <td>EmployeeId</td>
                    <td><input type="text" readonly="true" name="employeeid" value="<%=employee.getEmployeeId()%>"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="<%=employee.getUsername()%>"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" value="<%=employee.getPassword()%>"></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" value="<%=employee.getAddress()%>"></td>
                </tr>
                <tr>
                    <td><button  onclick="return confirmAction();" type="submit" name="submit" value="submit">Delete</button></td>
                </tr>
            </table>
        </form>
        <script type="text/javascript">
            function confirmAction() {
                return confirm('Bạn có chắc muốn xóa?');
            }
        </script>
    </body>
</html>
