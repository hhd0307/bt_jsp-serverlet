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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nguyen Tri
 */
@WebServlet(name = "EditEmployee", urlPatterns = {"/EditEmployee"})
public class EditEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditEmployee</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditEmployee at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        
        EmployeeBO empBo = new EmployeeBO();
        int emloyeeid = Integer.parseInt(request.getParameter("employeeid"));
        
        if ("submit".equals(request.getParameter("submit"))) {
            String name = request.getParameter("name");
            String pass = request.getParameter("password");
            
            String address = request.getParameter("address");
            empBo.editEmployee(emloyeeid, name, pass, address);
            response.sendRedirect("ListEmployeeServlet");
        } else {
            Employee employee = empBo.getInfomationEmployee(emloyeeid);
            request.setAttribute("employee", employee);
            RequestDispatcher rd = request.getRequestDispatcher("editEmployee.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
