<%-- 
    Document   : listEmployee
    Created on : May 3, 2018, 2:56:06 PM
    Author     : Nguyen Tri 
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.model.bean.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    <a href="addEmployee.jsp">Add emplpyee</a> 
                </td>
                <td><a href="LogoutServler">Logout</a></td>
            </tr>
        </table>
        <jsp:include page="timkiem.jsp"></jsp:include>
            <form action="ListEmployeeServlet" method="post">
                <table>
                    <tr>
                        <td>Name</td>
                        <td>Password</td>
                        <td>Address</td>
                        <td>*</td>
                        <td>*</td>
                    </tr>
                <%
                    ArrayList<Employee> listEmployee = (ArrayList<Employee>) request.getAttribute("listEmployee");
                    ArrayList<Employee> listsearchEmployee = (ArrayList<Employee>) request.getAttribute("employee");
                    if (request.getAttribute("employee") != null) {
                        listEmployee = listsearchEmployee;
                    }

                %>
                <%                    for (Employee employee : listEmployee) {
                %>
                <tr>

                    <td><%=employee.getUsername()%></td>
                    <td><%=employee.getPassword()%></td>
                    <td><%=employee.getAddress()%></td>
                    <td><a href="EditEmployee?employeeid=<%=employee.getEmployeeId()%>"/>Edit</td>
                    <td><a href="DeleteEmployee?employeeid=<%=employee.getEmployeeId()%>"/>Delete</td>
                </tr>
                <%
                    }
                %>
            </table>
        </form>
    </body>
</html>
