<%-- 
    Document   : login1
    Created on : May 3, 2018, 2:34:44 PM
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
        <form action="Checklogin" method="post">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="OK"/></td>
                    <td><input type="reset" value="Reset"/></td>
                </tr>
            </table>         
        </form>
    </body>
</html>
