/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trum.servlet;

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
@WebServlet(name = "AddEmployee", urlPatterns = {"/AddEmployee"})
public class AddEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddEmployee</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddEmployee at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        EmployeeBO employeeBo = new EmployeeBO();
//        String name = request.getParameter("name");
//        String pass = request.getParameter("password");
//        String address = request.getParameter("address");
//        employeeBo.addEmployee(name, pass, address);
//        response.sendRedirect("ListEmployeeServlet");

        if ("submit".equals(request.getParameter("submit"))) {
            String name = request.getParameter("name");
            String pass = request.getParameter("password");
            String address = request.getParameter("address");
            employeeBo.addEmployee(name, pass, address);
            response.sendRedirect("ListEmployeeServlet");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
