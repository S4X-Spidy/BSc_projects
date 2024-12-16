package com.studenthelpdesk.controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.studenthelpdesk.dao.UserDao;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        boolean isAuthenticated = userDao.authenticate(username, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("dashboard.html");
        } else {
            response.sendRedirect("login.html?error=Invalid credentials");
        }
    }
}
