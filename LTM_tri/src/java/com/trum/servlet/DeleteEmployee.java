/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trum.servlet;

import com.model.bean.Employee;
import com.model.bo.EmployeeBO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nguyen Tri
 */
@WebServlet(name = "DeleteEmployee", urlPatterns = {"/DeleteEmployee"})
public class DeleteEmployee extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteEmployee</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteEmployee at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        EmployeeBO employeeBO = new EmployeeBO();
        int id = Integer.parseInt(request.getParameter("employeeid"));
        if ("submit".equals(request.getParameter("submit"))) {
            employeeBO.deleteEmployee(id);
            response.sendRedirect("ListEmployeeServlet");
        } else {
            Employee employee = employeeBO.getInfomationEmployee(id);
            request.setAttribute("employee", employee);
            RequestDispatcher rd = request.getRequestDispatcher("deleteEmployee.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
